package com.example.restbackend.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.restbackend.model.Triage;
import com.example.restbackend.repository.TriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriageService {
    @Autowired
    private TriageRepository triageRepository;
    Triage triage = new Triage();

    public String getAdviceBySymptom(String symptom) {

         String result = triageRepository.findBySymptom(symptom)
                .map(Triage::getAdvice)
                .orElse(null);
         return result;
    }
}
