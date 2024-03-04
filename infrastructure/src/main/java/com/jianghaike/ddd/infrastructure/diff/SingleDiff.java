package com.jianghaike.ddd.infrastructure.diff;

import java.util.Objects;

/**
 * 单一差异
 * @author jianghaike
 */
public class SingleDiff implements Diff {

    private final DiffType diffType;

    private final Object oldValue;

    private final Object newValue;

    public SingleDiff(DiffType diffType, Object oldValue, Object newValue) {
        this.diffType = diffType;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public DiffType getDiffType() {
        return diffType;
    }

    @Override
    public Object getOldValue() {
        return oldValue;
    }

    @Override
    public Object getNewValue() {
        return newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleDiff that = (SingleDiff) o;
        return getDiffType() == that.getDiffType()
                && Objects.equals(getOldValue(), that.getOldValue())
                && Objects.equals(getNewValue(), that.getNewValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiffType(), getOldValue(), getNewValue());
    }

    @Override
    public String toString() {
        return "SingleDiff{" +
                "diffType=" + diffType +
                ", oldValue=" + oldValue +
                ", newValue=" + newValue +
                '}';
    }
}
