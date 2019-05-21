package com.example.demo.service;

import com.example.demo.api.TranslationRequest;
import com.example.demo.api.TranslationResponse;
import com.example.demo.api.TranslationResultResponse;
import com.example.demo.domain.*;
import com.example.demo.service.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TranslationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationService.class);

    private final PipelineService pipelineService;

    @Autowired
    public TranslationService(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    public TranslationResponse doTranslation(TranslationRequest request, String target){
        LOGGER.info("Translation requested value={} type={} target={}", request.getValue(), request.getType(), target);

        NumerationType targetType;
        try{
            targetType = NumerationType.valueOf(target);
        }catch (IllegalArgumentException e){
            String message = String.format("Unknown target type %s", target);
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }

        Numeric requestValue = this.getRequestValue(request);
        Pipeline<?, ?> pipeline =  pipelineService.findPipeline(requestValue.getClass(), targetType);

        return this.getTranslationResponse(request, targetType, requestValue, pipeline);

    }

    private TranslationResponse getTranslationResponse(TranslationRequest request, NumerationType targetType, Numeric requestValue, Pipeline pipeline) {
        TranslationResponse response = new TranslationResponse();
        response.setNumber(request.getValue());
        TranslationResultResponse resultResponse = new TranslationResultResponse();
        Numeric targetValue = (Numeric)pipeline.processItem(requestValue);
        resultResponse.setValue(targetValue.getValue());
        resultResponse.setTarget(targetType.name());
        response.setResult(resultResponse);
        return response;
    }

    private Numeric getRequestValue(TranslationRequest request){
        switch (request.getType()){
            case "BIN":
                return new Binary(request.getValue());
            case "DEC":
                return new Decimal(request.getValue());
            case "HEX":
                return new Hexadecimal(request.getValue());

        }
        throw new IllegalArgumentException(String.format("Unknown request type %s", request.getType()));
    }

}
