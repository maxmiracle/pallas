package ru.maximserver.pallas.domain;

import org.springframework.data.annotation.Id;
import lombok.Data;

import java.util.UUID;

@Data
public class Concept {
    @Id
    private UUID id;
    private String name;
    private String description;
}
