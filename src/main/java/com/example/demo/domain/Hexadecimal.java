package com.example.demo.domain;

public class Hexadecimal implements Numeric{
    private final String value;

    public Hexadecimal(String value) {
        // TODO: validate input
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
