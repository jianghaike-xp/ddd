package com.jianghaike.ddd.domain.event;

import java.time.Instant;
import java.util.UUID;

/**
 * @author jianghaike
 */
public abstract class DomainEvent {

    private final String id = UUID.randomUUID().toString().replace("-", "");

    private final Instant createdAt = Instant.now();

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
