package com.example.restbackend.repository;

import com.example.restbackend.model.Triage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TriageRepository extends JpaRepository<Triage, Long> {
    Optional<Triage> findBySymptom(String symptom);

}
