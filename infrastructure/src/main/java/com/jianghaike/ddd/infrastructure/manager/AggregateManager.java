package com.jianghaike.ddd.infrastructure.manager;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.type.Identifier;
import com.jianghaike.ddd.infrastructure.diff.EntityDiff;

/**
 * 聚合管理器
 * @author jianghaike
 */
public interface AggregateManager<T extends Aggregate<ID>, ID extends Identifier<?>> {

    /**
     * 附加
     * @param aggregate 聚合
     */
    void attach(T aggregate);

    /**
     * 附加
     * @param aggregate 聚合
     * @param id ID
     */
    void attach(T aggregate, ID id);

    /**
     * 解除附加
     * @param aggregate 聚合
     */
    void detach(T aggregate);

    /**
     * 查找
     * @param id ID
     * @return 聚合
     */
    T find(ID id);

    /**
     * 检测变化
     * @param aggregate 聚合
     * @return 实体差异
     */
    EntityDiff detectChanges(T aggregate);

    /**
     * 合并
     * @param aggregate 聚合
     */
    void merge(T aggregate);
}
