package com.jianghaike.ddd.domain.event;

/**
 * @author jianghaike
 */
public interface DomainEventSender {

    /**
     * 发送领域事件
     * @param event 领域事件
     */
    void send(DomainEvent event);
}
