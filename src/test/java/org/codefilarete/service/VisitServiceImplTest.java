package org.codefilarete.service;

import org.codefilarete.model.Visit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitServiceImplTest {

    @Test
    void createVisit() {
        VisitServiceImpl testInstance = new VisitServiceImpl();
        Visit dummyVisit = new Visit();
        Visit createdVisit = testInstance.createVisit(dummyVisit);
        assertEquals(42, createdVisit.getId());
    }
    
}

