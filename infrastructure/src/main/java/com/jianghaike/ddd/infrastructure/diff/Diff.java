package com.jianghaike.ddd.infrastructure.diff;

/**
 * 差异
 * @author jianghaike
 */
public interface Diff {

    /**
     * 获取差异类型
     * @return 差异类型
     */
    default DiffType getDiffType() {
        return DiffType.UNTOUCHED;
    }

    /**
     * 获取旧值
     * @return 旧值
     */
    default Object getOldValue() {
        return null;
    }

    /**
     * 获取新值
     * @return 新值
     */
    default Object getNewValue() {
        return null;
    }
}
