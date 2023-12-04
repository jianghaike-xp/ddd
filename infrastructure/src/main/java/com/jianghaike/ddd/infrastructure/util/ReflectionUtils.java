package com.jianghaike.ddd.infrastructure.util;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 反射工具
 * @author jianghaike
 */
public class ReflectionUtils {

    public static void writeField(String fieldName, Object object, Object id) {
        Field field = org.springframework.util.ReflectionUtils.findField(object.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return;
        }

        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        org.springframework.util.ReflectionUtils.setField(field, object, id);
    }

    public static Object getField(String fieldName, Object object) {
        Field field = org.springframework.util.ReflectionUtils.findField(object.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return null;
        }

        return org.springframework.util.ReflectionUtils.getField(field, object);
    }
}
