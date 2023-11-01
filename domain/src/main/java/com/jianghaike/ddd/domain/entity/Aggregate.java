package com.jianghaike.ddd.domain.entity;

import com.jianghaike.ddd.domain.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 聚合
 * @author jianghaike
 */
public abstract class Aggregate extends Entity {

    private List<DomainEvent> events;

    protected Aggregate() {
        super();
    }

    /**
     * 触发事件
     * @param event 事件
     */
    protected final void raiseEvent(DomainEvent event) {
        this.getEvents().add(event);
    }

    /**
     * 清除事件
     */
    public final void clearEvents() {
        this.getEvents().clear();
    }

    /**
     * 获取事件列表
     * @return 事件列表
     */
    public final List<DomainEvent> getEvents() {
        return Objects.isNull(events) ? new ArrayList<>() : events;
    }
}
