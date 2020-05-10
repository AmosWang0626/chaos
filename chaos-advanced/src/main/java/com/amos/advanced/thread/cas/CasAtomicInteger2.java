package com.amos.advanced.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DESCRIPTION: 简单测试 AtomicInteger 实现 CAS
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public class CasAtomicInteger2 {

    private static AtomicInteger ai = new AtomicInteger(100);

    public static void main(String[] args) throws InterruptedException {
        aiCompareAndSet();
    }

    public static void aiCompareAndSet() throws InterruptedException {
        new Thread(() -> {
            boolean compareAndSet = ai.compareAndSet(100, 120);
            System.out.println("compareAndSet(100, 120) >>>>> " + compareAndSet);
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            boolean compareAndSet = ai.compareAndSet(120, 100);
            System.out.println("compareAndSet(120, 100) >>>>> " + compareAndSet);
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            boolean compareAndSet = ai.compareAndSet(100, 188);
            System.out.println("compareAndSet(100, 188) >>>>> " + compareAndSet);
        }).start();

        System.out.println("AtomicInteger CompareAndSet Finish >>>>> " + ai.get());
    }

}
