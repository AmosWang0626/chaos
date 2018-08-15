package cn.amos.common.simple.thread.pool;

import java.util.concurrent.*;

/**
 * PROJECT: chaos
 * NOTE: 类说明
 *
 * @author AMOS
 * @date 2018/8/14 15:30
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        testPool();
        testScheduleDelayPool();
        testScheduleRatePool();
    }

    /**
     * 1.单个线程池
     * 2.固定大小线程池
     * 3.无限大小线程池
     */
    private static void testPool() {
        ExecutorService service;
        // 创建单个线程的线程池
        /*service = Executors.newSingleThreadExecutor();*/
        // 固定线程大小的线程池
        service = Executors.newFixedThreadPool(5);
        // 无限个线程的线程池
        /*service = Executors.newCachedThreadPool();*/
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int index = i;
            service.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ", run " + index);
            });

        }
        service.shutdown();
    }

    /**
     * 从字面意义上可以理解为就是以固定延迟（时间）来执行线程任务，不确切。
     * 它实际上是不管线程任务的执行时间的，每次都要把任务执行完成后再延迟固定时间后再执行下一次。
     */
    private static void testScheduleDelayPool() {
        long start = System.currentTimeMillis();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        // 延迟启动，延迟两秒，间隔两秒再次执行
        ScheduledFuture<?> scheduledFuture = service.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", running! " +
                    ((System.currentTimeMillis() - start) / 1000));
        }, 2, 2, TimeUnit.SECONDS);

        // ScheduledExecutorService 执行11秒后shutdown
        service.schedule(() -> {
            scheduledFuture.cancel(true);
            service.shutdown();
            System.out.println(Thread.currentThread().getName() + ", shutdown! " +
                    ((System.currentTimeMillis() - start) / 1000));
        }, 11, TimeUnit.SECONDS);
    }

    /**
     * 是以固定频率来执行线程任务，固定频率的含义就是可能设定的固定时间不足以完成线程任务，
     * 但是它不管，达到设定的延迟时间了就要执行下一次了。
     */
    private static void testScheduleRatePool() {
        long start = System.currentTimeMillis();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        // 延迟启动，延迟两秒，间隔两秒再次执行
        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + ", run prepare! " +
                    ((System.currentTimeMillis() - start) / 1000));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", running! " +
                    ((System.currentTimeMillis() - start) / 1000));
        }, 2, 2, TimeUnit.SECONDS);

        // ScheduledExecutorService 执行11秒后shutdown
        service.schedule(() -> {
            scheduledFuture.cancel(true);
            service.shutdown();
            System.out.println(Thread.currentThread().getName() + ", shutdown! " +
                    ((System.currentTimeMillis() - start) / 1000));
        }, 11, TimeUnit.SECONDS);
    }

}
