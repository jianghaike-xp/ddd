package com.jianghaike.ddd.domain.entity;

/**
 * 已标识的领域对象
 * @author jianghaike
 */
public abstract class IdentifiedDomainObject {

    private long id = -1;

    protected IdentifiedDomainObject() {
        super();
    }

    protected long getId() {
        return this.id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
