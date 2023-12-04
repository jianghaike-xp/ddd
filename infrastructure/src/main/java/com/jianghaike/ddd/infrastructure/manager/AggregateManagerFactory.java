package com.jianghaike.ddd.infrastructure.manager;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.type.Identifier;

/**
 * 聚合管理器工厂
 * @author jianghaike
 */
public class AggregateManagerFactory {

    public static <T extends Aggregate<ID>, ID extends Identifier<?>> AggregateManager<T, ID> newInstance(Class<? extends T> targetClass) {
        return new ThreadLocalAggregateManager<>(targetClass);
    }

    private AggregateManagerFactory() {

    }
}
