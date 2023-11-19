package com.example.restbackend.controller;

import com.example.restbackend.model.Triage;
import com.example.restbackend.repository.TriageRepository;
import com.example.restbackend.service.TriageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TriageController {

    @Autowired
    private TriageService triageService;

    @Autowired
    TriageRepository triagerepository;

    @GetMapping("/advice")
    public ResponseEntity<String> getAdvice(@RequestParam(defaultValue = "Insert symptom") String symptom) {
        if ("Insert symptom".equals(symptom)) {
            return ResponseEntity.badRequest().body("Please provide a valid symptom for accurate advice.");
        }
        String advice = triageService.getAdviceBySymptom(symptom);
        return advice != null ? ResponseEntity.ok(advice) : ResponseEntity.notFound().build();
    }



}
