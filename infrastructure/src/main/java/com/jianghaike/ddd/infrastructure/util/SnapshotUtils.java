package com.jianghaike.ddd.infrastructure.util;

import com.jianghaike.ddd.domain.model.Aggregate;

import java.io.*;

/**
 * 快照工具
 * @author jianghaike
 */
public class SnapshotUtils {

    private SnapshotUtils() {

    }

    /**
     * 快照（深度拷贝）
     * @param aggregate 聚合
     * @return 聚合快照
     * @throws IOException 输入输出异常
     * @throws ClassNotFoundException 类没找到异常
     */
    @SuppressWarnings("unchecked")
    public static <T extends Aggregate<?>> T snapshot(T aggregate) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(aggregate);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        T snapshot = (T) objectInputStream.readObject();

        objectOutputStream.close();
        byteArrayOutputStream.close();

        objectInputStream.close();
        byteArrayInputStream.close();
        return snapshot;
    }

}
