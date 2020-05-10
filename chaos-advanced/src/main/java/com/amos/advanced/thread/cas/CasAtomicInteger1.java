package com.amos.advanced.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * DESCRIPTION: 简单测试 AtomicInteger 实现 CAS
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public class CasAtomicInteger1 {

    private static int num = 0;
    private static AtomicInteger atomicNum = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(CasAtomicInteger1::increment1);
            thread.start();
            thread.join();
        }
        System.out.println(CasAtomicInteger1.num);
        System.out.println(CasAtomicInteger1.atomicNum.get());
    }

    public static void increment1() {
        num++;
        // CAS = UnSafe.class > HotSpot > UnSafe.cpp
        // > atomic_windows_x86.inline.hpp > cmpxchg
        atomicNum.incrementAndGet();
    }

}
