package ru.maximserver.pallas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.util.UUID;

@Data
public class Concept implements Persistable<UUID> {
    @Id
    private UUID id;
    private String name;
    private String description;

    @Getter(AccessLevel.NONE)
    @Transient
    private boolean isNewOverride = false;

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        if (isNewOverride)
            return true;
        else
            return id == null;
    }
}
