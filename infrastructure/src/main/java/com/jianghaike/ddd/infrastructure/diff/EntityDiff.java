package com.jianghaike.ddd.infrastructure.diff;

/**
 * 实体差异
 * @author jianghaike
 */
public class EntityDiff {

    public static final EntityDiff EMPTY = new EntityDiff();

    private boolean hasChanges;

    public boolean isEmpty() {
        return hasChanges;
    }

    public void setHasChanges(boolean hasChanges) {
        this.hasChanges = hasChanges;
    }

    public boolean isSelfModified() {
        return false;
    }

    public Diff getDiff(String fieldName) {
        return null;
    }
}
