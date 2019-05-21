package com.example.demo.service.converter;


import com.example.demo.domain.Decimal;
import com.example.demo.domain.Hexadecimal;

public class HexDecimalConverter implements Converter<Hexadecimal, Decimal> {

    @Override
    public Decimal convert(Hexadecimal value) {
        return new Decimal(Integer.valueOf(value.getValue(), 16).toString());
    }
}
