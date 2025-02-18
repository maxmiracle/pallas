package ru.maximserver.pallas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.maximserver.pallas.domain.Concept;
import ru.maximserver.pallas.repository.ReactiveConceptRepository;

@RestController
@RequestMapping("/concept")
public class ConceptController {

    @Autowired
    private ReactiveConceptRepository conceptRepository;

    @PostMapping
    Mono<Concept> create(@RequestBody Concept concept) {
        concept.setId(null);
        return conceptRepository.save(concept);
    }
}
