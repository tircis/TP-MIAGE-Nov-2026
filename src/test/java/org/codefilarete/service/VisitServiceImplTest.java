package org.codefilarete.service;

import org.codefilarete.miage.domain.inbound.VisitDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitServiceImplTest {

    @Test
    void createVisit() {
        VisitServiceImpl testInstance = new VisitServiceImpl();
        VisitDTO dummyVisitDTO = new VisitDTO(42, "a dummy visit", null, null);
        VisitDTO createdVisit = testInstance.createVisit(dummyVisitDTO);
        assertEquals(42, createdVisit.id());
    }
    
}

