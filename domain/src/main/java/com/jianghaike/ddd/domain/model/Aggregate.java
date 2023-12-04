package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.event.DomainEvent;
import com.jianghaike.ddd.domain.type.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 聚合
 * @author jianghaike
 */
public abstract class Aggregate<ID extends Identifier> extends Entity<ID> {

    private List<DomainEvent> events;

    protected Aggregate() {
        super();
    }

    /**
     * 触发事件
     * @param event 事件
     */
    protected final void raiseEvent(DomainEvent event) {
        this.events().add(event);
    }

    /**
     * 清除事件
     */
    public final void clearEvents() {
        this.events().clear();
    }

    /**
     * 获取事件列表
     * @return 事件列表
     */
    public final List<DomainEvent> events() {
        return Objects.isNull(this.events) ? new ArrayList<>() : this.events;
    }
}
