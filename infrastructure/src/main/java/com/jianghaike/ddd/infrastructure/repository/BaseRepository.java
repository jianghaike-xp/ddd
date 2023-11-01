package com.jianghaike.ddd.infrastructure.repository;

import com.jianghaike.ddd.domain.entity.Aggregate;
import com.jianghaike.ddd.domain.repository.Repository;
import com.jianghaike.ddd.infrastructure.dao.DomainEventDao;

/**
 * 仓储根
 * @author jianghaike
 */
public abstract class BaseRepository<T extends Aggregate> implements Repository<T> {

    private final DomainEventDao eventDao;

    protected BaseRepository(DomainEventDao eventDao) {
        this.eventDao = eventDao;
    }

    /**
     * 保存聚合根（事件）
     * @param aggregate 聚合根
     */
    @Override
    public final void save(T aggregate) {
        eventDao.save(aggregate.getEvents());
        aggregate.clearEvents();
        this.doSave(aggregate);
    }

    /**
     * 保存聚合根
     * @param aggregate 聚合根
     */
    protected abstract void doSave(T aggregate);
}
