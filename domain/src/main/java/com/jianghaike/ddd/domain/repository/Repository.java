package com.jianghaike.ddd.domain.repository;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.type.Identifier;

/**
 * 仓储
 * @author jianghaike
 */
public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {

    /**
     * 通过ID寻找聚合
     * @param id ID
     * @return 聚合
     */
    T find(ID id);

    /**
     * 保存一个聚合（事件）
     * @param aggregate 聚合
     */
    void save(T aggregate);

    /**
     * 将一个聚合从仓储移除
     * @param aggregate 聚合
     */
    void remove(T aggregate);


}
