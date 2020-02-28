package com.amos.design.behavior.iterator;

/**
 * DESCRIPTION: 抽象集合 [add(), get(), size()]
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public abstract class BaseCluster<T> {

    /**
     * 新增
     *
     * @param ts array
     * @return 新增成功数量
     */
    public abstract int add(T... ts);

    /**
     * 根据 index 获取
     *
     * @param index Index
     * @return t
     */
    public abstract T get(int index);

    /**
     * 集合容量
     *
     * @return size
     */
    public abstract int size();

}
