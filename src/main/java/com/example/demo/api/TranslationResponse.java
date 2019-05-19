package com.example.demo.api;

public class TranslationResponse {

    private String number;

    private TranslationResultResponse result;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TranslationResultResponse getResult() {
        return result;
    }

    public void setResult(TranslationResultResponse result) {
        this.result = result;
    }
}
