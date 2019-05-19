package com.example.demo.service.converter;

import com.example.demo.model.Decimal;
import com.example.demo.model.Hexadecimal;

public class HexDecimalConverter implements Converter<Hexadecimal, Decimal> {

    @Override
    public Decimal convert(Hexadecimal value) {
        return new Decimal(Integer.valueOf(value.getValue(), 16).toString());
    }
}
