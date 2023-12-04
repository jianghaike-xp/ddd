package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.type.Identifier;

/**
 * 标识领域对象
 * @author jianghaike
 */
public abstract class IdentifiedDomainObject<ID extends Identifier> implements Identifiable<ID> {

    private long id = -1;

    protected IdentifiedDomainObject() {
        super();
    }

    protected long id() {
        return this.id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
