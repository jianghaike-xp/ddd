package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.event.DomainEvent;
import com.jianghaike.ddd.domain.type.Identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 聚合
 * @author jianghaike
 */
public abstract class Aggregate<ID extends Identifier<?>> extends Entity<ID> {

    private static final long serialVersionUID = -1088640007364814492L;

    private final List<DomainEvent> events = new ArrayList<>();

    protected Aggregate() {
        super();
    }

    /**
     * 触发事件
     * @param event 事件
     */
    protected final void raiseEvent(DomainEvent event) {
        events.add(event);
    }

    /**
     * 清除事件
     */
    public final void clearEvents() {
        events.clear();
    }

    /**
     * 获取事件列表
     * @return 事件列表
     */
    public final List<DomainEvent> events() {
        return Collections.unmodifiableList(events);
    }
}
