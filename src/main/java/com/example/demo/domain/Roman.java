package com.example.demo.domain;

public class Roman implements Numeric{
    private final String value;

    public Roman(String value) {
        // TODO: validate input
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
