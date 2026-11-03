package org.codefilarete.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        VisitController testInstance = new VisitController();
        
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
                  "id": 42,
                  "description": "Annual checkup",
                  "startTime": "2026-11-02T09:00:00",
                  "endTime": "2026-11-02T09:30:00",
                  "new": false
                }
                """;
        assertEquals(objectMapper.readTree(expectedJson), objectMapper.readTree(response));
    }
}
