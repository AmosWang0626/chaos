package com.amos.advanced.thread.juc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION: 类似计数器，执行本功能前，必须前边 n 个线程都执行完成
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 */
public class CountDownLatchTest {

    private static List<String> planCompany = Arrays.asList("东方航空", "吉祥航空", "春秋航空");
    private static String[] target = {"上海", "重庆"};

    public static void main(String[] args) throws InterruptedException {
        List<String> info = new ArrayList<>();

        CountDownLatch countDownLatch = new CountDownLatch(planCompany.size());

        Thread[] planThreads = new Thread[3];
        for (int i = 0; i < planCompany.size(); i++) {
            int currentIndex = i;
            planThreads[i] = new Thread(() -> {
                // 随机休眠时间 & 随机机票数目
                int count = new Random().nextInt(5);
                try {
                    TimeUnit.SECONDS.sleep(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(planCompany.get(currentIndex) + "查询完成");
                info.add(Arrays.toString(target) + " 机票数: " + count);

                countDownLatch.countDown();
            });
            planThreads[i].start();
        }

        countDownLatch.await();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");

        info.forEach(System.out::println);
    }

}
