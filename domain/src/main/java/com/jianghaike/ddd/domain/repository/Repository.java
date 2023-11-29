package com.jianghaike.ddd.domain.repository;

import com.jianghaike.ddd.domain.model.Aggregate;

/**
 * 仓储
 * @author jianghaike
 */
public interface Repository<T extends Aggregate> {

    /**
     * 保存聚合根（事件）
     * @param aggregate 聚合根
     */
    void save(T aggregate);
}
