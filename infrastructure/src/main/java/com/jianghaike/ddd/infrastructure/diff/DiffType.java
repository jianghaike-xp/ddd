package com.jianghaike.ddd.infrastructure.diff;

/**
 * 差异类型
 * @author jianghaike
 */
public enum DiffType {

    /**
     * 新增
     */
    ADDED(),

    /**
     * 移除
     */
    REMOVED(),

    /**
     * 修改
     */
    MODIFIED(),

    /**
     * 无变化
     */
    UNTOUCHED()
}
