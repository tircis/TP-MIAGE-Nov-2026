package org.codefilarete.service;

import org.codefilarete.model.Visit;

public class VisitServiceImpl implements VisitService {

    /**
     * Creates a new Visit.
     */
    @Override
    public Visit createVisit(Visit visit) {
        visit.setId(42);
        return visit;
    }
}
