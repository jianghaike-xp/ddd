package com.jianghaike.ddd.domain.model;

import java.io.Serializable;

/**
 * 标识值对象
 * @author jianghaike
 */
public abstract class IdentifiedValueObject extends IdentifiedDomainObject implements Serializable {

    private static final long serialVersionUID = 1581271456412267165L;

    protected IdentifiedValueObject() {
        super();
    }
}
