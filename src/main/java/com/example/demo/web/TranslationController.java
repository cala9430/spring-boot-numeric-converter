package com.example.demo.web;

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

    @PostMapping(path = "translate/{target}")
    public ResponseEntity<TranslationResponse> doTranslate(@PathVariable("target") String target, @RequestBody TranslationRequest request){
        return ResponseEntity.ok(this.translationService.doTranslation(request, target));

    }

}

