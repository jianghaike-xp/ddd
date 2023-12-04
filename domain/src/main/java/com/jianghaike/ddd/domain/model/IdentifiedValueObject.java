package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.type.Identifier;

import java.io.Serializable;

/**
 * 标识值对象
 * @author jianghaike
 */
public abstract class IdentifiedValueObject<ID extends Identifier<?>> extends IdentifiedDomainObject<ID> implements Serializable {

    private static final long serialVersionUID = 1581271456412267165L;

    protected IdentifiedValueObject() {
        super();
    }
}
