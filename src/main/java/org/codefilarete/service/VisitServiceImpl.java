package org.codefilarete.service;

import org.codefilarete.miage.domain.inbound.VisitDTO;
import org.codefilarete.miage.domain.inbound.VisitService;

public class VisitServiceImpl implements VisitService {

    /**
     * Creates a new Visit.
     */
    @Override
    public VisitDTO createVisit(VisitDTO visit) {
        return new VisitDTO(42, visit.description(), visit.startTime(), visit.endTime());
    }
}
