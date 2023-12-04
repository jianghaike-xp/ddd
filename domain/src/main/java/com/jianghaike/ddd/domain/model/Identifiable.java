package com.jianghaike.ddd.domain.model;

import com.jianghaike.ddd.domain.type.Identifier;

/**
 * 可辨别的对象
 * @author jianghaike
 */
public interface Identifiable<ID extends Identifier> {

    /**
     * 获取ID
     * @return ID
     */
    ID getId();
}
