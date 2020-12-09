package com.amos.advanced.concurrent.base;

import java.util.function.Supplier;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/28
 */
public class RunnableThread implements Runnable {

    private static Integer count = 0;

    private static RunnableThread create(Supplier<RunnableThread> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableThread instance = RunnableThread.create(RunnableThread::new);
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
        System.out.println("耗时 " + (System.currentTimeMillis() - start) + "毫秒!!!");
    }

    @Override
    public void run() {
        method();
    }

    private void method() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }
}
