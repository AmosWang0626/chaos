package cn.amos.common.simple.generic;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/10/23
 */
public class BaseGeneric<T> {

    /**
     * <? extends T>表示该通配符所代表的类型是T类型的子类。
     * <? super T>表示该通配符所代表的类型是T类型的父类。
     */

    public T hello(T t) {
        return t;
    }

    static <V> V hi(V v) {
        return v;
    }

}
