package com.example.demo.web.controller;

import com.example.demo.api.TranslationRequest;
import com.example.demo.api.TranslationResponse;
import com.example.demo.service.TranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @PostMapping(path = "translate")
    public ResponseEntity<TranslationResponse> doTranslate(@RequestParam("target") String target, @RequestBody TranslationRequest request){
        return ResponseEntity.ok(this.translationService.doTranslation(request, target));

    }

    @ExceptionHandler({ IllegalArgumentException.class })
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}

