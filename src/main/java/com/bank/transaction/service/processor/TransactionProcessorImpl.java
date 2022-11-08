package com.bank.transaction.service.processor;

import com.bank.transaction.service.processor.consts.MessageRoutingConst;
import com.bank.transaction.service.processor.entity.Account;
import com.bank.transaction.service.processor.entity.Transaction;
import com.bank.transaction.service.processor.enums.TransactionStatus;
import com.bank.transaction.service.processor.specification.IAccountRepository;
import com.bank.transaction.service.processor.specification.ITransactionProcessor;
import com.bank.transaction.service.processor.specification.ITransactionRepository;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

/**
 * Implementation of ITransactionRepository
 * */
@Repository
@AllArgsConstructor
public class TransactionProcessorImpl implements ITransactionProcessor {

    private Channel channel;

    private ITransactionRepository transactionRepository;

    private IAccountRepository accountRepository;

    @Qualifier("messageQueueProp")
    private Map<String, String> messageQueueProps;

    /**
     * Process pending transactions
     * */
    @Override
    public void processPendingTransaction() {
        String queueName = "transactionServiceQueueForEmail";
        Boolean isDurableQueue = Boolean.parseBoolean(messageQueueProps.get("isDurableQueue"));
        Boolean isExclusiveToThisConnection = Boolean.parseBoolean(messageQueueProps.get("isExclusiveToThisConnection")); // since multiple consumer instances are running.
        Boolean isQueueAutomaticallyDeleteWhenDisconnect = Boolean.parseBoolean(messageQueueProps.get("isQueueAutomaticallyDeleteWhenDisconnect"));
        try {
            channel.queueDeclare(queueName, isDurableQueue,
                    isExclusiveToThisConnection,
                    isQueueAutomaticallyDeleteWhenDisconnect, null);

            String routingKey = MessageRoutingConst.PROCESS_ROUTING_MESSAGE;
            String exchangeName = messageQueueProps.get("exchangeName");
            channel.queueBind(queueName, exchangeName, routingKey);

            // Consume Message
            boolean autoAck = false;
            channel.basicConsume(queueName, autoAck, "myConsumerTag",
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag,
                                                   Envelope envelope,
                                                   AMQP.BasicProperties properties,
                                                   byte[] body)
                                throws IOException
                        {
                            String routingKey = envelope.getRoutingKey();
                            String contentType = properties.getContentType();
                            long deliveryTag = envelope.getDeliveryTag();
                            String message = new String(body, StandardCharsets.UTF_8);

                            UUID transactionUUID = UUID.fromString(message);
                            Transaction transactionData = getTransaction(transactionUUID, transactionRepository);
                            if (transactionData.getAccount().getAccountBalance().compareTo(transactionData.getTransactionAmount()) > 0) {

                                Account senderAccount = transactionData.getAccount();
                                senderAccount.setAccountBalance(senderAccount.getAccountBalance().subtract(transactionData.getTransactionAmount()));
                                accountRepository.save(senderAccount);

                                Account receiverAccount = getAccount(transactionData.getBeneficiaryAccountNumber(), accountRepository);
                                receiverAccount.setAccountBalance(receiverAccount.getAccountBalance().add(transactionData.getTransactionAmount()));
                                accountRepository.save(receiverAccount);

                                transactionData.setTransactionStatus(TransactionStatus.COMPLETED);
                                updateTransaction(transactionData, transactionRepository);

                            }
                            System.out.println("Message: " + message + " Routing Key: " + routingKey);
                            channel.basicAck(deliveryTag, false);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Transaction getTransaction ( UUID transactionId, final ITransactionRepository transactionRepository) {
        Transaction transaction = transactionRepository.getByTransactionNumber(transactionId);
        return transaction;
    }

    private Account getAccount(UUID accountNumber, final IAccountRepository accountRepository) {
        Account account = accountRepository.getByAccountNumber(accountNumber);
        return account;
    }

    private Transaction updateTransaction(final Transaction transaction, final ITransactionRepository transactionRepository) {
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return updatedTransaction;
    }

}
