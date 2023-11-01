package com.jianghaike.ddd.domain.event;

/**
 * @author jianghaike
 */
public interface DomainEventConsumeRecorder {

    boolean record(DomainEvent event);

    void deleteAll();
}
