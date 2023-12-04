package com.jianghaike.ddd.domain.type;

import java.util.Objects;

/**
 * 数字ID
 * @author jianghaike
 */
public class DigitalId implements Identifier<Long> {

    private final long id;

    public DigitalId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("数字ID不能为空或小于等于0！");
        }

        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public static DigitalId valueOf(long value) {
        return new DigitalId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DigitalId digitalId = (DigitalId) o;
        return Objects.equals(getId(), digitalId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
