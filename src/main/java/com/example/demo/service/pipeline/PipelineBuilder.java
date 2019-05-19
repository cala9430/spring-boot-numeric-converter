package com.example.demo.service.pipeline;

import com.example.demo.service.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class PipelineBuilder<In, Out>
{
    private List<Converter<?, ?>> stages;

    public static <In, Out> PipelineBuilder<In, Out> create(Converter<In, Out> stage)
    {
        PipelineBuilder<In, Out> pipelineBuilder = new PipelineBuilder<>(stage);
        return pipelineBuilder;
    }

    private PipelineBuilder(Converter<In, Out> stage)
    {
        stages = new ArrayList<>();
        stages.add(stage);
    }

    public <NextOut> PipelineBuilder<In, NextOut> add(Converter<Out, NextOut> stage)
    {
        stages.add(stage);

        // This cast is safe as per construction of the pipeline
        @SuppressWarnings("unchecked")
        PipelineBuilder<In, NextOut> result = (PipelineBuilder<In, NextOut>) this;
        return result;
    }

    public Pipeline<In, Out> build()
    {
        return new Pipeline<>(stages);
    }
}
