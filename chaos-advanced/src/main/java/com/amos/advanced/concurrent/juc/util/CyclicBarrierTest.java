package com.amos.advanced.concurrent.juc.util;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION: 类似发令枪
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 */
public class CyclicBarrierTest {

    /**
     * 发令枪起跑问题
     */
    public static void main(String[] args) {
        final int size = 8;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);

        Thread[] planThreads = new Thread[size];
        for (int i = 0; i < size; i++) {
            planThreads[i] = new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getId() + " 准备好了~~");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + " >>> 起跑 >>>");
            });
            planThreads[i].start();
        }

    }

}
