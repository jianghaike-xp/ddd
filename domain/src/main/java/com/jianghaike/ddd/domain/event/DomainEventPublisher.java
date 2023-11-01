package com.jianghaike.ddd.domain.event;

/**
 * 领域事件发布者
 * @author jianghaike
 */
public interface DomainEventPublisher {

    /**
     * 发布下一批
     */
    void publishNextBatch();

    /**
     * 发布下一批
     * @param size 数量
     */
    void publishNextBatch(int size);

    /**
     * 强制发布
     * @param eventId 领域事件ID
     */
    void forcePublish(String eventId);
}
