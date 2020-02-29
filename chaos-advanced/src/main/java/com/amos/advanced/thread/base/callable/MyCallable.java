package com.amos.advanced.thread.base.callable;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/4/1
 */
public class MyCallable<T> implements Callable<T> {

    @Override
    public T call() throws Exception {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        Object obj = "Hello, i am callable!";
        return (T) obj;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("callable-pool-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        Future<String> submit = pool.submit(new MyCallable<>());
        String result;
        // result = submit.get(3000, TimeUnit.MILLISECONDS);
        // System.out.println("result is " + result);

        while (!submit.isDone()) {
        }
        result = submit.get();
        System.out.println("result is " + result);

        // gracefully shutdown
        pool.shutdown();
    }

}
