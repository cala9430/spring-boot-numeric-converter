package com.example.demo.service.converter;

import com.example.demo.model.Binary;
import com.example.demo.model.Decimal;
import org.springframework.stereotype.Service;

@Service
public class DecimalBinaryConverter implements Converter<Decimal, Binary> {

    @Override
    public Binary convert(Decimal value) {
        return new Binary(Integer.toString(Integer.valueOf(value.getValue()),2));
    }

}
