package com.jianghaike.ddd.domain.repository;

import com.jianghaike.ddd.domain.entity.BaseAggregate;

/**
 * 仓储
 * @author jianghaike
 */
public interface Repository<T extends BaseAggregate> {

    /**
     * 保存聚合根（事件）
     * @param aggregate 聚合根
     */
    void save(T aggregate);
}
