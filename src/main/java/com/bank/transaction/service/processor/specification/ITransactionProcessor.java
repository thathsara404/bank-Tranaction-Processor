package com.bank.transaction.service.processor.specification;

/**
 * Represent the specification which process transactions.
 * */
public interface ITransactionProcessor {

    /**
     * Process pending transactions
     * */
    public abstract void processPendingTransaction();

}
