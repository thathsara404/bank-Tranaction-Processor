package com.bank.transaction.service.processor.enums;

public enum AccountType {

    SAVING("Saving Account Type"),
    FIXED("Fixed Account Type"),
    BUSINESS("Business Account Type");

    private String description;
    private Integer code;

    AccountType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
