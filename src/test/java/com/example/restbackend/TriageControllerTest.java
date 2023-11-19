package com.example.restbackend;
import com.example.restbackend.controller.TriageController;
import com.example.restbackend.model.Triage;
import com.example.restbackend.repository.TriageRepository;
import com.example.restbackend.service.TriageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional // Use @Transactional to ensure test data doesn't persist in the database
public class TriageControllerTest {

    @Autowired
    private TriageController triageController;

    @Autowired
    private TriageService triageService;

    @Autowired
    private TriageRepository triageRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAdvice_ValidSymptom() throws Exception {
        // Arrange - Save test data to the repository
        Triage testTriage = new Triage("Fever", "Rest and drink fluids");
        triageRepository.save(testTriage);

        // Act & Assert using the Controller
        mockMvc.perform(MockMvcRequestBuilders.get("/advice")
                        .param("symptom", "Fever")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Assert using the Service
        String advice = triageService.getAdviceBySymptom("Fever");
        // Add further assertions here

        // Clean up by deleting test data from the repository
        triageRepository.delete(testTriage);
    }

    // Add more test methods as needed
}
