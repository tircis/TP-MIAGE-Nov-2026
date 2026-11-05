package org.codefilarete.miage.domain.inbound;

public interface CreateVisitCommandHandler {

    VisitDTO createVisit(CreateVisitCommand visit);
}
