package ru.maximserver.pallas.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.maximserver.pallas.domain.Concept;

import java.util.UUID;

public interface ReactiveConceptRepository extends ReactiveCrudRepository<Concept, UUID> {
}