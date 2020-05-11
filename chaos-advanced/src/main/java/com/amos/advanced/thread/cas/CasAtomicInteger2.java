package com.amos.advanced.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * DESCRIPTION: 简单测试 AtomicInteger 实现 CAS
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public class CasAtomicInteger2 {

    private static AtomicInteger ai = new AtomicInteger(100);
    private static AtomicStampedReference<Integer> asr
            = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) throws InterruptedException {
        aiCompareAndSet();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        asrCompareAndSet();
    }

    public static void asrCompareAndSet() throws InterruptedException {
        new Thread(() -> {
            boolean compareAndSet = asr.compareAndSet(100, 120,
                    asr.getStamp(), asr.getStamp() + 1);
            System.out.println("asrCompareAndSet(100, 120) >>>>> " + compareAndSet);
            boolean compareAndSet2 = asr.compareAndSet(120, 100,
                    asr.getStamp(), asr.getStamp() + 1);
            System.out.println("asrCompareAndSet(120, 100) >>>>> " + compareAndSet2);
        }).start();

        new Thread(() -> {
            int stamp = asr.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean compareAndSet = asr.compareAndSet(120, 100,
                    stamp, stamp + 1);
            System.out.println("asrCompareAndSet(120, 100) >>>>> " + compareAndSet);
        }).start();

        System.out.println("AtomicStampedReference<Integer> CompareAndSet Finish >>>>> " + ai.get());
    }

    public static void aiCompareAndSet() throws InterruptedException {
        new Thread(() -> {
            boolean compareAndSet = ai.compareAndSet(100, 120);
            System.out.println("aiCompareAndSet(100, 120) >>>>> " + compareAndSet);
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            boolean compareAndSet = ai.compareAndSet(120, 100);
            System.out.println("aiCompareAndSet(120, 100) >>>>> " + compareAndSet);
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            boolean compareAndSet = ai.compareAndSet(100, 188);
            System.out.println("aiCompareAndSet(100, 188) >>>>> " + compareAndSet);
        }).start();

        System.out.println("AtomicInteger CompareAndSet Finish >>>>> " + ai.get());
    }

}
