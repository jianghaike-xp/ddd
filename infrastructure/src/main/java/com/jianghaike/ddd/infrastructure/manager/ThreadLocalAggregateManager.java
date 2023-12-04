package com.jianghaike.ddd.infrastructure.manager;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.type.Identifier;
import com.jianghaike.ddd.infrastructure.diff.EntityDiff;

/**
 * 本地线程聚合管理器
 * @author jianghaike
 */
public class ThreadLocalAggregateManager<T extends Aggregate<ID>, ID extends Identifier<?>> implements AggregateManager<T, ID> {

    private final ThreadLocal<DbContext<T, ID>> context;

    public ThreadLocalAggregateManager(Class<? extends T> targetClass) {
        this.context = ThreadLocal.withInitial(() -> new DbContext<>(targetClass));
    }

    @Override
    public void attach(T aggregate) {
        context.get().attach(aggregate);
    }

    @Override
    public void attach(T aggregate, ID id) {
        context.get().setId(aggregate, id);
        context.get().attach(aggregate);
    }

    @Override
    public void detach(T aggregate) {
        context.get().detach(aggregate);
    }

    @Override
    public T find(ID id) {
        return context.get().find(id);
    }

    @Override
    public EntityDiff detectChanges(T aggregate) {
        return context.get().detectChanges(aggregate);
    }

    @Override
    public void merge(T aggregate) {
        context.get().merge(aggregate);
    }
}
