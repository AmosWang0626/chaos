package com.amos.advanced.thread.volatle;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION: VolatileDemo
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public class VolatileBusiness {

    private static final int MAX_VALUE = 5;

    private volatile static int current;

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("thread-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20), factory,
                // 1. CallerRunsPolicy 不抛弃不放弃(重试直至执行成功)
                // 2. AbortPolicy 拒绝任务并且抛出异常
                // 3. DiscardPolicy 拒绝任务不抛出异常
                // 4. DiscardOldestPolicy 喜新厌旧(抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列)
                new ThreadPoolExecutor.CallerRunsPolicy());

        // ReadThread
        executor.execute(() -> {
            int localValue = current;
            while (localValue < MAX_VALUE) {
                if (localValue != current) {
                    System.out.println(Thread.currentThread().getName() + " 消费 " + current);
                    localValue = current;
                }
            }
        });

        // WriteThread
        executor.execute(() -> {
            int localValue = current;
            while (localValue < MAX_VALUE) {
                System.out.println(Thread.currentThread().getName() + " 生产 " + ++localValue);
                current = localValue;

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
    }

}
