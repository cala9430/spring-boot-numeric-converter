package com.example.demo.service.pipeline;


import com.example.demo.service.converter.Converter;

import java.util.List;

public class Pipeline<In, Out>
{
    private List<Converter<?, ?>> converters;

    Pipeline(List<Converter<?, ?>> Converters)
    {
        this.converters = Converters;
    }

    public Out processItem (In item){
        Object current = item;
        for (Converter<?, ?> stage : converters)
        {
            current = apply(stage, current);
        }

        // This cast is safe as per construction of the pipeline
        @SuppressWarnings("unchecked")
        Out result = (Out) current;
        return result;
    }

    private <I, O> O apply(Converter<I, O> stage, Object dataItem)
    {
        // This cast is safe as per construction of the pipeline
        @SuppressWarnings("unchecked")
        I typedDataItem = (I)dataItem;
        return stage.convert(typedDataItem);
    }
}