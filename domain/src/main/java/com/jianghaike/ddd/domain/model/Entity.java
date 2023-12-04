package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.type.Identifier;

/**
 * 实体
 * @author jianghaike
 */
public abstract class Entity<ID extends Identifier<?>> extends IdentifiedDomainObject<ID> {

    private static final long serialVersionUID = 3421878732682945601L;

    protected Entity() {
        super();
    }
}
