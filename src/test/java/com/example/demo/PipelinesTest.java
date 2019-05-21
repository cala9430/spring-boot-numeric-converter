package com.example.demo;

import com.example.demo.domain.Binary;
import com.example.demo.domain.Hexadecimal;
import com.example.demo.domain.Roman;
import com.example.demo.service.converter.*;
import com.example.demo.service.pipeline.Pipeline;
import com.example.demo.service.pipeline.PipelineBuilder;
import org.junit.Assert;
import org.junit.Test;

public class PipelinesTest {

    @Test
    public void hexToRomanPipelineTest(){
        Pipeline<Hexadecimal, Roman> pipeline = PipelineBuilder
                .create(new HexDecimalConverter())
                .add(new DecimalRomanConverter())
                .build();

        Assert.assertEquals(new Roman("X").getValue(), pipeline.processItem(new Hexadecimal("a")).getValue());
    }

    @Test
    public void hexToBinaryPipelineTest() {
        Pipeline<Hexadecimal, Binary> pipeline = PipelineBuilder
                .create(new HexDecimalConverter())
                .add(new DecimalBinaryConverter())
                .build();

        Assert.assertEquals(new Binary("1010").getValue(), pipeline.processItem(new Hexadecimal("a")).getValue());
    }

    @Test
    public void binaryToRomanPipelineTest() {
        Pipeline<Binary, Roman> pipeline = PipelineBuilder
                .create(new BinaryDecimalConverter())
                .add(new DecimalRomanConverter())
                .build();

        Assert.assertEquals(new Roman("X").getValue(), pipeline.processItem(new Binary("1010")).getValue());
    }

    @Test
    public void binaryToHexPipelineTest() {
        Pipeline<Binary, Hexadecimal> pipeline = PipelineBuilder
                .create(new BinaryDecimalConverter())
                .add(new DecimalHexConverter())
                .build();

        Assert.assertEquals(new Hexadecimal("a").getValue(), pipeline.processItem(new Binary("1010")).getValue());
    }
}
