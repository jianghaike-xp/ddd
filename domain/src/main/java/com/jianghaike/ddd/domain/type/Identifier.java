package com.jianghaike.ddd.domain.type;

import java.io.Serializable;

/**
 * ID类型DP的Marker接口
 * @author jianghaike
 */
public interface Identifier<T> extends Serializable {

    /**
     * 获取值
     * @return 值
     */
    T getId();
}
