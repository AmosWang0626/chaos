package com.amos.design.behavior.iterator;

/**
 * DESCRIPTION: 迭代器实现类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public class IteratorImpl<T> extends BaseIterator<T> {

    private int current = 0;

    public IteratorImpl(BaseCluster<T> cluster) {
        super(cluster);
    }

    @Override
    public T first() {
        return getCluster().get(0);
    }

    @Override
    public T current() {
        return getCluster().get(current);
    }

    @Override
    public T next() {
        return getCluster().get(++current);
    }

    @Override
    public Boolean hasNext() {
        return current < getCluster().size();
    }

    @Override
    public void range() {
        System.out.println(first());
        do {
            System.out.println(next());
        } while (hasNext());
    }
}
