package com.bank.transaction.service.processor.enums;

public enum TransactionStatus {

    PROCESSING("Processing Status", 0),
    COMPLETED("Completed Status", 1),
    FAILED("Failed Status", 2);

    private String description;
    private Integer code;

    TransactionStatus(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String toString() {
        return description;
    }

}
