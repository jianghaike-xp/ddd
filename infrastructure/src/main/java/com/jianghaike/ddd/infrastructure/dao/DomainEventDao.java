package com.jianghaike.ddd.infrastructure.dao;

import com.jianghaike.ddd.domain.event.DomainEvent;

import java.util.List;

/**
 * 领域事件数据访问对象
 * @author jiang
 */
public interface DomainEventDao {

    /**
     * 批量保存事件
     * @param events 事件列表
     */
    void save(List<DomainEvent> events);

    /**
     * 删除事件
     * @param eventId 事件ID
     */
    void delete(String eventId);

    /**
     * 获取事件
     * @param eventId 事件ID
     * @return 事件
     */
    DomainEvent get(String eventId);

    /**
     * 查询下一批待发布事件列表
     * @param size 数量
     * @return 事件列表
     */
    List<DomainEvent> nextPublishBatch(int size);

    /**
     * 标记事件已发布
     * @param eventId 事件ID
     */
    void markAsPublished(String eventId);

    /**
     * 标记事件发布失败
     * @param eventId 事件ID
     */
    void markAsPublishFailed(String eventId);

    /**
     * 删除所有事件
     */
    void deleteAll();
}
