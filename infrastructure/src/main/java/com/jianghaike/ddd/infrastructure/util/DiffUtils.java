package com.jianghaike.ddd.infrastructure.util;

import com.jianghaike.ddd.infrastructure.diff.EntityDiff;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

/**
 * 差异工具
 * @author jianghaike
 */
public class DiffUtils {

    private DiffUtils() {

    }

    public static EntityDiff diff(Object snapshot, Object obj) {
        DiffNode diffNode = ObjectDifferBuilder.buildDefault()
                .compare(obj, snapshot);
        if (!diffNode.hasChanges()) {
            return EntityDiff.EMPTY;
        }

        EntityDiff entityDiff = new EntityDiff();
        entityDiff.setHasChanges(true);
        diffNode.visit((node, visit) -> {
            boolean hasChanges = node.hasChanges();
            Object objValue = node.canonicalGet(obj);
            Object snapshotValue = node.canonicalGet(snapshot);
            // TODO 处理其他的逻辑和构建EntityDiff对象
        });

        return entityDiff;
    }
}
