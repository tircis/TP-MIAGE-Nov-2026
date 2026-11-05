package org.codefilarete.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.codefilarete.miage.domain.inbound.VisitDTO;
import org.codefilarete.miage.domain.inbound.VisitService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class VisitControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void addVisit_acceptsJsonAndReturnsUpdatedPetAsJson() throws Exception {
        VisitService visitService = mock(VisitService.class);
        VisitDTO dummyVisit = new VisitDTO(null, "a dummy visit", null, null);
        when(visitService.createVisit(any(VisitDTO.class))).thenReturn(dummyVisit);

        VisitController testInstance = new VisitController(visitService);
        
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
                  "id": null,
                  "description": "a dummy visit",
                  "startTime": null,
                  "endTime": null
                }
                """;
        assertEquals(objectMapper.readTree(expectedJson), objectMapper.readTree(response));
    }
}
