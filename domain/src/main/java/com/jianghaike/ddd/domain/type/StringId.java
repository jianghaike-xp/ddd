package com.jianghaike.ddd.domain.type;

import java.util.Objects;

/**
 * 字符串ID
 * @author jianghaike
 */
public class StringId implements Identifier<String> {

    private final String id;

    public StringId(String id) {
        if (Objects.isNull(id) || id.isEmpty()) {
            throw new IllegalArgumentException("字符串ID不能为空或空字符串！");
        }

        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    public static StringId valueOf(String value) {
        return new StringId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringId stringId = (StringId) o;
        return Objects.equals(getId(), stringId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return id;
    }
}
