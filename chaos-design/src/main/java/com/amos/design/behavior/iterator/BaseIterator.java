package com.amos.design.behavior.iterator;

/**
 * DESCRIPTION: 抽象迭代器
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public abstract class BaseIterator<T> {

    private BaseCluster<T> cluster;

    public BaseIterator(BaseCluster<T> cluster) {
        this.cluster = cluster;
    }

    public BaseCluster<T> getCluster() {
        return cluster;
    }

    /**
     * get first
     *
     * @return Object
     */
    public abstract T first();

    /**
     * get current
     *
     * @return Object
     */
    public abstract T current();

    /**
     * get next
     *
     * @return Object
     */
    public abstract T next();

    /**
     * has next ?
     *
     * @return Object
     */
    public abstract Boolean hasNext();

    /**
     * range
     */
    public abstract void range();

}
