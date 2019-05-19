package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.service.converter.*;
import com.example.demo.service.pipeline.Pipeline;
import com.example.demo.service.pipeline.PipelineBuilder;
import org.javatuples.Pair;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PipelineService {

    private final Map<Pair<Class, NumerationType>, Pipeline<? extends Numeric,? extends Numeric>> pipelines = new HashMap<>();

    @PostConstruct
    public void init(){

        // Decimal to Hexadecimal
        pipelines.put(new Pair<>(Decimal.class, NumerationType.HEX), PipelineBuilder
                .create(new DecimalHexConverter())
                .build());

        // Hexadecimal to Decimal
        pipelines.put(new Pair<>(Hexadecimal.class, NumerationType.DECIMAL), PipelineBuilder
                .create(new HexDecimalConverter())
                .build());

        // Decimal to Binary
        pipelines.put(new Pair<>(Decimal.class, NumerationType.BIN), PipelineBuilder
                .create(new DecimalBinaryConverter())
                .build());

        // Binary to Decimal
        pipelines.put(new Pair<>(Binary.class, NumerationType.DECIMAL), PipelineBuilder
                .create(new BinaryDecimalConverter())
                .build());

        // Decimal to Roman
        pipelines.put(new Pair<>(Decimal.class, NumerationType.ROMAN), PipelineBuilder
                .create(new DecimalRomanConverter())
                .build());

        // Hexadecimal to Roman
        pipelines.put(new Pair<>(Hexadecimal.class, NumerationType.ROMAN), PipelineBuilder
                .create(new HexDecimalConverter())
                .add(new DecimalRomanConverter())
                .build());

        // Binary to Roman
        pipelines.put(new Pair<>(Binary.class, NumerationType.ROMAN), PipelineBuilder
                .create(new BinaryDecimalConverter())
                .add(new DecimalRomanConverter())
                .build());

        // Binary to Hexadecimal
        pipelines.put(new Pair<>(Binary.class, NumerationType.HEX), PipelineBuilder
                .create(new BinaryDecimalConverter())
                .add(new DecimalHexConverter())
                .build());

        // Hexadecimal to Binary
        pipelines.put(new Pair<>(Binary.class, NumerationType.BIN), PipelineBuilder
                .create(new HexDecimalConverter())
                .add(new DecimalBinaryConverter())
                .build());


    }

    public Pipeline<? extends Numeric, ? extends Numeric> findPipeline(Class in, NumerationType out){
        Pair<Class, NumerationType> key = new Pair<>(in, out);
        if(!pipelines.containsKey(key)){
            throw new NotImplementedException();
        }
        return pipelines.get(key);
    }
}
