package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.type.Identifier;

import java.io.Serializable;

/**
 * 可辨别的对象
 * @author jianghaike
 */
public interface Identifiable<ID extends Identifier<?>> extends Serializable {

    /**
     * 获取ID
     * @return ID
     */
    ID getId();
}
