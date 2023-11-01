package com.jianghaike.ddd.domain.event;

import java.time.Instant;

/**
 * @author jianghaike
 */
public abstract class DomainEvent {

    private String id;

    private Instant createdAt = Instant.now();

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
