package com.amos.advanced.concurrent.volatle;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION: Hello
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/12/9
 */
public class FlagVolatileMain {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("flag-volatile-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20), factory, new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
            System.out.println("赋值成功！");
        });

        executor.execute(() -> {
            while (flag) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("休眠完成!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("厉害了！竟然出来了！");
        });

        executor.shutdown();
        System.out.println("拜拜~~");
    }

}
