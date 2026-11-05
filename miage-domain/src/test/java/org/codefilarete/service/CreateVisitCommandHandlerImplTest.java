package org.codefilarete.service;

import org.codefilarete.miage.domain.inbound.CreateVisitCommand;
import org.codefilarete.miage.domain.inbound.VisitDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateVisitCommandHandlerImplTest {

    @Test
    void createVisit() {
        CreateVisitCommandHandlerImpl testInstance = new CreateVisitCommandHandlerImpl();
        CreateVisitCommand dummyVisitCommand = new CreateVisitCommand("a dummy visit", null, null);
        VisitDTO createdVisit = testInstance.createVisit(dummyVisitCommand);
        assertEquals(42, createdVisit.id());
    }
    
}

