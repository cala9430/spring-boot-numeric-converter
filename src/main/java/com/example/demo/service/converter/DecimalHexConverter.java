package com.example.demo.service.converter;

import com.example.demo.model.Decimal;
import com.example.demo.model.Hexadecimal;
import org.springframework.stereotype.Service;

@Service
public class DecimalHexConverter implements Converter<Decimal, Hexadecimal> {

    @Override
    public Hexadecimal convert(Decimal value) {
        return new Hexadecimal(Integer.toString(Integer.valueOf(value.getValue()), 16));
    }
}
