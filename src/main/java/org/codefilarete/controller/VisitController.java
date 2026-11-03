package org.codefilarete.controller;

import org.codefilarete.model.Visit;
import org.codefilarete.service.VisitService;
import org.codefilarete.service.VisitServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    private final VisitService visitService = new VisitServiceImpl();

    public VisitController() {
    }

    @PostMapping(path = "/visit/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Visit addVisit(@RequestBody Visit visit) {
        return visitService.createVisit(visit);
    }
}



