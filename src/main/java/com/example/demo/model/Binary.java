package com.example.demo.model;

public class Binary implements Numeric{
    private final String value;

    public Binary(String value) {
        // TODO: validate input
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
