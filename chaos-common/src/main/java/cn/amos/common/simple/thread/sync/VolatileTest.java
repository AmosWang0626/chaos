package cn.amos.common.simple.thread.sync;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * volatile 即时修改,即时生效
 * 保证线程之间的可见性
 *
 * @author AmosWang
 */
public class VolatileTest {

    private static volatile boolean ready = true;

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("hello-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5,
                10000, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(), factory);

        executor.execute(() -> {
            while (ready) {
                System.out.println(Thread.currentThread().getName() + " 啦啦啦");
            }
        });

        Thread.sleep(50);

        executor.execute(() -> {
            ready = false;
            System.out.println("shutdown!");
            executor.shutdown();
        });
    }
}
