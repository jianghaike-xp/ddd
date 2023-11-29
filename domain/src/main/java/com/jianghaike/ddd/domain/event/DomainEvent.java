package com.jianghaike.ddd.domain.event;

import java.time.Instant;
import java.util.UUID;

/**
 * @author jianghaike
 */
public abstract class DomainEvent {

    private final String id = UUID.randomUUID().toString().replace("-", "");

    private final Instant createdAt = Instant.now();

    public String id() {
        return this.id;
    }

    public Instant createdAt() {
        return this.createdAt;
    }
}
