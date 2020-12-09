package com.amos.advanced.concurrent.begin;

/**
 * 模块名称: chaos
 * 模块描述: 并发-线程安全
 *
 * @author amos.wang
 * @date 2020/12/8 14:08
 */
public class IncrementData {

    private int data = 0;

    public int increment() {
        synchronized (IncrementData.class) {
            return ++data;
        }
    }

}
