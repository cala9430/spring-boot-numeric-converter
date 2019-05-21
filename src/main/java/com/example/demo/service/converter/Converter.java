package com.example.demo.service.converter;

public interface Converter<V, T> {

    T convert(V value);

}
