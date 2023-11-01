package com.jianghaike.ddd.domain.entity;

import com.jianghaike.ddd.domain.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合根
 * @author jianghaike
 */
public abstract class BaseAggregate {

    private List<DomainEvent> events;

    /**
     * 触发事件
     * @param event 事件
     */
    protected final void raiseEvent(DomainEvent event) {
        getEvents().add(event);
    }

    /**
     * 清除事件
     */
    public final void clearEvents() {
        getEvents().clear();
    }

    /**
     * 获取事件列表
     * @return 事件列表
     */
    public final List<DomainEvent> getEvents() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events;
    }
}
