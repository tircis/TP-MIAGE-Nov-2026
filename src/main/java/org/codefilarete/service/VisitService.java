package org.codefilarete.service;

import org.codefilarete.model.Visit;

public class VisitService {

    /**
     * Creates a new Visit.
     */
    public Visit createVisit(Visit visit) {
        visit.setId(42);
        return visit;
    }
}
