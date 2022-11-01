package com.bank.transaction.service.processor.specification;

import com.bank.transaction.service.processor.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Represent the specification which includes transaction related operations.
 * */
@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

    public abstract Transaction getByTransactionNumber(UUID transactionNumber);

}
