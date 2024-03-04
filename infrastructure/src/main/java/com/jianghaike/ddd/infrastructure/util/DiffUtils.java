package com.jianghaike.ddd.infrastructure.util;

import com.jianghaike.ddd.domain.model.Aggregate;
import com.jianghaike.ddd.domain.type.Identifier;
import com.jianghaike.ddd.infrastructure.diff.*;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 差异工具
 * @author jianghaike
 */
public class DiffUtils {

    private DiffUtils() {

    }

    public static <T extends Aggregate<ID>, ID extends Identifier<?>> EntityDiff diff(T base, T work) {

        DiffNode diffNode = ObjectDifferBuilder.buildDefault()
                .compare(work, base);
        if (!diffNode.hasChanges()) {
            return EntityDiff.EMPTY;
        }

        EntityDiff entityDiff = new EntityDiff();
        entityDiff.setHasChanges(true);
        diffNode.visit((node, visit) -> {
            boolean hasChanges = node.hasChanges();
            Object objValue = node.canonicalGet(work);
            Object snapshotValue = node.canonicalGet(base);
            // TODO 处理其他的逻辑和构建EntityDiff对象
        });

        return entityDiff;
    }

    private static Diff doDiff(Class<?> clazz, Object baseObject, Object workObject) {
        return null;
    }

    private static Diff doListDiff(List<?> baseList, List<?> workList) {
        return null;
    }

    private static void handleEntityType(List<?> baseList, List<?> workList, ListDiff listDiff) {

    }

    private static void handleNonEntityType(List<?> baseList, List<?> workList, ListDiff listDiff) {

    }

    private static Object getIdentifier(Object object) {
        return null;
    }

    private static boolean isDiff(Object baseObject, Object workObject) {
        return false;
    }

    private static DiffType basicDiffType(Object baseObject, Object workObject) {
        if (Objects.isNull(baseObject) && Objects.isNull(workObject)) {
            return DiffType.UNTOUCHED;
        }
        if (Objects.isNull(baseObject)) {
            return DiffType.ADDED;
        }
        if (Objects.isNull(workObject)) {
            return DiffType.REMOVED;
        }
        return null;
    }

//    public static void main(String[] args) {
//        ListDiff<SingleDiff> a = new ListDiff<>("a");
//        a.add(new SingleDiff(DiffType.ADDED, null, "abc"));
//        a.add(new SingleDiff(DiffType.MODIFIED, "abc", "bcd"));
//
//        ListDiff<SingleDiff> b = new ListDiff<>("b");
//        b.add(new SingleDiff(DiffType.ADDED, null, "qwe"));
//        b.add(new SingleDiff(DiffType.MODIFIED, "abc", "bnm"));
//
//        DiffNode diffNode = ObjectDifferBuilder.buildDefault()
//                .compare(a, b);
//        diffNode.visit((node, visit) -> {
//            System.out.println(node.getPath() + " count: " + node.childCount());
//            Class<?> clazz = node.getValueType();
//            if (Collection.class.isAssignableFrom(clazz)) {
//
//                boolean hasChanges = node.hasChanges();
//                Object snapshotValue = node.canonicalGet(a);
//                Object objValue = node.canonicalGet(b);
//                final String message = node.getPath() + " changed from " +
//                        snapshotValue + " to " + objValue + " ============= " + node.getState()  + " ++++++++ " + node.getPropertyName()
//                        + " ------- " + node.getValueType().getName();
//                System.out.println(message);
//            }
//        });
//    }
}
