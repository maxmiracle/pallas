package ru.maximserver.pallas.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ConceptController {

    @Autowired
    private ReactiveConceptRepository conceptRepository;

    @PostMapping
    public Mono<Concept> create(@RequestBody Concept concept) {
        concept.setNewOverride(true);
        return conceptRepository.save(concept)
                .doOnNext(concept1 -> log.info(concept1.toString()));
    }
}
