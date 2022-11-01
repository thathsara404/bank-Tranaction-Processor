package com.bank.transaction.service.processor.enums;

public enum CountryName {

    US("United States", 0),
    CANADA("Canada", 1),
    NORWAY("Norway", 2),
    ESTONIA("Estonia", 3),
    SWEDEN("Sweden", 4)
    ;

    private String description;
    private Integer code;

    CountryName(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String toString() {
        return description;
    }

}
