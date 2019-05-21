package com.example.demo.domain;

public class Decimal implements Numeric{

    private final String value;

    public Decimal(String value) {
        // TODO: validate input
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
