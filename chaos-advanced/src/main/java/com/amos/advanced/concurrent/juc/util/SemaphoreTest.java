package com.amos.advanced.concurrent.juc.util;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION: Semaphore 锁测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 */
public class SemaphoreTest {

    /**
     * 停车场问题（车位有限）
     */
    public static void main(String[] args) {
        final int size = 5;
        final int requests = 20;

        Semaphore semaphore = new Semaphore(size);

        for (int i = 0; i < requests; i++) {
            new Thread(() -> {
                int stayTime = new Random().nextInt(5) + 1;
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 车来了 >>>");
                    TimeUnit.SECONDS.sleep(stayTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " 车停留了 [" + stayTime + "小时] 离开了 ~~~");
            }, String.format("CAR[%s]", i + 1)).start();
        }

    }

}
