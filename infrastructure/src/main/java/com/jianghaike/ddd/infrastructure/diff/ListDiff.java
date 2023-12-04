package com.jianghaike.ddd.infrastructure.diff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 列表差异
 * @author jianghaike
 */
public class ListDiff<T extends Diff> implements Diff, Iterable<T> {

    private final List<T> diffList;

    public ListDiff() {
        this.diffList = new ArrayList<>();
    }

    public void add(T diff) {
        diffList.add(diff);
    }

    @Override
    public Iterator<T> iterator() {
        return diffList.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        diffList.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return diffList.spliterator();
    }
}
