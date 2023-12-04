package com.jianghaike.ddd.infrastructure.manager;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.type.Identifier;
import com.jianghaike.ddd.infrastructure.diff.EntityDiff;
import com.jianghaike.ddd.infrastructure.util.DiffUtils;
import com.jianghaike.ddd.infrastructure.util.ReflectionUtils;
import com.jianghaike.ddd.infrastructure.util.SnapshotUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 数据库上下文
 * @author jianghaike
 */
public class DbContext<T extends Aggregate<ID>, ID extends Identifier<?>> {

    private final Class<? extends T> aggregateClass;

    private final Map<ID, T> aggregateMap;

    public DbContext(Class<? extends T> aggregateClass) {
        this.aggregateClass = aggregateClass;
        this.aggregateMap = new HashMap<>();
    }

    public void attach(T aggregate) {
        if (Objects.isNull(aggregate.getId())) {
            return;
        }

        if (!aggregateMap.containsKey(aggregate.getId())) {
            this.merge(aggregate);
        }
    }

    public void detach(T aggregate) {
        if (Objects.isNull(aggregate.getId())) {
            return;
        }

        aggregateMap.remove(aggregate.getId());
    }

    public EntityDiff detectChanges(T aggregate) {
        if (Objects.isNull(aggregate.getId())) {
            return EntityDiff.EMPTY;
        }

        T snapshot = aggregateMap.get(aggregate.getId());
        if (Objects.isNull(snapshot)) {
            this.attach(aggregate);
        }

        return DiffUtils.diff(snapshot, aggregate);
    }

    public T find(ID id) {
        return aggregateMap.get(id);
    }

    public void merge(T aggregate) {
        if (Objects.isNull(aggregate.getId())) {
            return;
        }

        T snapshot;
        try {
            snapshot = SnapshotUtils.snapshot(aggregate);
        } catch (Exception e) {
            throw new IllegalArgumentException("执行快照失败！", e);
        }
        aggregateMap.put(aggregate.getId(), snapshot);
    }

    public void setId(T aggregate, ID id) {
        final String idFieldName = "id";
        ReflectionUtils.writeField(idFieldName, aggregate, id);
    }

    public Class<? extends T> getAggregateClass() {
        return aggregateClass;
    }
}
