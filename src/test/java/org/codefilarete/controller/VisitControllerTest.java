package org.codefilarete.controller;

import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.codefilarete.model.Visit;
import org.codefilarete.service.VisitService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class VisitControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void addVisit_acceptsJsonAndReturnsUpdatedPetAsJson() throws Exception {
        int expectedVisitId = new Random().nextInt();
        VisitController testInstance = new VisitController(new DummyVisitService(expectedVisitId));
        
        MockMvc mockMvc = standaloneSetup(testInstance).build();

        String response = mockMvc.perform(post("/visit/")
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content("""
                                {
                                  "id": null,
                                  "description": "Annual checkup",
                                  "startTime": "2026-11-02T09:00:00",
                                  "endTime": "2026-11-02T09:30:00"
                                }
                                """))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        String expectedJson = """
                {
                  "id": %d,
                  "description": "Annual checkup",
                  "startTime": "2026-11-02T09:00:00",
                  "endTime": "2026-11-02T09:30:00",
                  "new": false
                }
                """.formatted(expectedVisitId);
        assertEquals(objectMapper.readTree(expectedJson), objectMapper.readTree(response));
    }
    
    private record DummyVisitService(int visitId) implements VisitService {
        
        @Override
        public Visit createVisit(Visit visit) {
            visit.setId(visitId);
            return visit;
        }
    }
}
