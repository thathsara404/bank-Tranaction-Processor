package com.bank.transaction.service.processor.enums;

public enum Currency {

    USD("USD", 0),
    CAD("Canadian Dollar", 1),
    NOK("NOK", 2),
    EURO("EURO", 3);

    private String description;
    private Integer code;

    Currency(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String toString() {
        return description;
    }

}
