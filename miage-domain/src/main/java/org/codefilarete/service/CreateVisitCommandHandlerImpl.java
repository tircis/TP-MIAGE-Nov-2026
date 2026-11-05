package org.codefilarete.service;

import org.codefilarete.miage.domain.inbound.CreateVisitCommand;
import org.codefilarete.miage.domain.inbound.VisitDTO;
import org.codefilarete.miage.domain.inbound.CreateVisitCommandHandler;
import org.codefilarete.model.Visit;

public class CreateVisitCommandHandlerImpl implements CreateVisitCommandHandler {

    /**
     * Creates a new Visit.
     */
    @Override
    public VisitDTO createVisit(CreateVisitCommand visit) {
        Visit newVisit = new Visit();
        newVisit.setDescription(visit.description());
        newVisit.setStartTime(visit.startTime());
        newVisit.setEndTime(visit.endTime());
        return new VisitDTO(newVisit.getId(), newVisit.getDescription(), newVisit.getStartTime(), newVisit.getEndTime());
    }
}
