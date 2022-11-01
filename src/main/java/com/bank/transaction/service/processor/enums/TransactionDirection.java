package com.bank.transaction.service.processor.enums;

public enum TransactionDirection {

    IN("In Coming", 0),
    OUT("Out Going", 1);

    private String description;
    private Integer code;

    TransactionDirection(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String toString() {
        return description;
    }

}
