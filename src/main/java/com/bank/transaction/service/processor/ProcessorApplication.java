package com.bank.transaction.service.processor;

import com.rabbitmq.client.Connection;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ProcessorApplication implements CommandLineRunner {

	TransactionProcessorImpl transactionProcessor;

	@Override
	public void run(String... args) throws Exception {
		transactionProcessor.processPendingTransaction();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

}
