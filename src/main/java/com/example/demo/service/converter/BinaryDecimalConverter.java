package com.example.demo.service.converter;

import com.example.demo.model.Binary;
import com.example.demo.model.Decimal;

public class BinaryDecimalConverter implements Converter<Binary, Decimal> {

    @Override
    public Decimal convert(Binary value) {
        return new Decimal(Integer.valueOf(value.getValue(),2).toString());
    }
}
