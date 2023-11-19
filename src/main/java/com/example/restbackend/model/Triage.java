package com.example.restbackend.model;

import jakarta.persistence.*;
import org.hibernate.Length;

@Entity
public class Triage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "symptom")
    private String symptom;

    @Column(name = "advice", length = 4000)
    private String advice;
    public Triage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }


    public Triage(String symptom, String advice) {
        this.symptom = symptom;
        this.advice = advice;
    }
}
