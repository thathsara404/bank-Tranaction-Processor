package com.bank.transaction.service.processor.enums;

public enum ErrorMessage {

    NOT_FOUND("Requested resource not found"),
    UNEXPECTED_RESULT_FOUND("Unexpected result found"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    DATA_DUPLICATION_ERROR("Data duplication error"),
    BAD_REQUEST("Bad request");

    private String description;

    ErrorMessage (String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
