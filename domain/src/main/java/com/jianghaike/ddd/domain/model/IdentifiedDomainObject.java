package com.jianghaike.ddd.domain.model;

/**
 * 标识领域对象
 * @author jianghaike
 */
public abstract class IdentifiedDomainObject {

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
