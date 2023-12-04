package com.jianghaike.ddd.infrastructure.manager;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.repository.Repository;
import com.jianghaike.ddd.domain.type.Identifier;
import com.jianghaike.ddd.infrastructure.diff.EntityDiff;
import com.sun.istack.internal.NotNull;

import java.util.Objects;

/**
 * 聚合仓储支持
 * @author jianghaike
 */
public abstract class AggregateRepositorySupport<T extends Aggregate<ID>, ID extends Identifier<?>> implements Repository<T, ID> {

    private final AggregateManager<T, ID> aggregateManager;

    protected AggregateRepositorySupport(Class<T> targetClass) {
        this.aggregateManager = AggregateManagerFactory.newInstance(targetClass);
    }

    @Override
    public void attach(T aggregate) {
        this.aggregateManager.attach(aggregate);
    }

    @Override
    public void detach(T aggregate) {
        this.aggregateManager.detach(aggregate);
    }

    @Override
    public T find(ID id) {
        T aggregate = this.onSelect(id);
        if (Objects.nonNull(aggregate)) {
            // 这里就是让查询出来的对象能够被追踪。
            // 如果自己实现了一个定制查询接口，要记得单独调用attach。
            this.attach(aggregate);
        }

        return aggregate;
    }

    @Override
    public void remove(T aggregate) {
        this.onDelete(aggregate);
        // 删除停止追踪
        this.detach(aggregate);
    }

    @Override
    public void save(T aggregate) {
        // 如果没有ID，直接插入
        if (Objects.isNull(aggregate.getId())) {
            this.onInsert(aggregate);
            this.attach(aggregate);
            return;
        }

        // 检测差异
        EntityDiff diff = aggregateManager.detectChanges(aggregate);
        if (diff.isEmpty()) {
            return;
        }

        this.onUpdate(aggregate, diff);
        aggregateManager.merge(aggregate);
    }

    /**
     * 插入
     * @param aggregate 聚合
     */
    protected abstract void onInsert(T aggregate);

    /**
     * 查询
     * @param id ID
     * @return 聚合
     */
    protected abstract T onSelect(ID id);

    /**
     * 更新
     * @param aggregate 聚合
     * @param diff 差异
     */
    protected abstract void onUpdate(T aggregate, EntityDiff diff);

    /**
     * 删除
     * @param aggregate 聚合
     */
    protected abstract void onDelete(T aggregate);

}
