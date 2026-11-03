package org.codefilarete.controller;

import org.codefilarete.model.Visit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {

    public VisitController() {
    }

    @PostMapping(path = "/visit/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Visit addVisit(@RequestBody Visit visit) {
        visit.setId(42);
        return visit;
    }
}
