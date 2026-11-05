package org.codefilarete.controller;

import org.codefilarete.miage.domain.inbound.CreateVisitCommand;
import org.codefilarete.miage.domain.inbound.VisitDTO;
import org.codefilarete.miage.domain.inbound.CreateVisitCommandHandler;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    private final CreateVisitCommandHandler createVisitHandler;

    public VisitController(CreateVisitCommandHandler createVisitHandler) {
        this.createVisitHandler = createVisitHandler;
    }

    @PostMapping(path = "/visit/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public VisitDTO addVisit(@RequestBody CreateVisitCommand visitCommand) {
        return createVisitHandler.createVisit(visitCommand);
    }
}



