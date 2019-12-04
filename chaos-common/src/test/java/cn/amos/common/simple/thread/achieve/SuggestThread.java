package cn.amos.common.simple.thread.achieve;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * NOTE: 线程池方式创建线程实例
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class SuggestThread {

    /**
     * 线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
     * 说明：使用线程池的好处是减少在创建和销毁线程上所花的时间以及系统资源的开销，解决资源不足的问题。
     * 如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者 "过度切换" 的问题。
     */
    public static void main(String[] args) {
        // 创建线程工厂,并设置线程名字格式
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();

        /*
         * int corePoolSize 核心线程数。
         * int maximumPoolSize 线程池所能容纳的最大线程数。
         * long keepAliveTime 非核心线程的闲置超时时间，超过这个时间就会被回收。
         * TimeUnit unit 指定keepAliveTime的单位，如TimeUnit.SECONDS。
         * BlockingQueue<Runnable> workQueue 线程池中的任务队列。
         * ThreadFactory threadFactory 线程工厂，提供创建新线程的功能。
         * RejectedExecutionHandler handler 线程池对拒绝任务的处理策略。
         *
         * if (corePoolSize > maximumPoolSize) throw IllegalArgumentException(非法调度Exception)
         */
        ExecutorService singleThreadPool = new ThreadPoolExecutor(12, 24,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 12; i++) {
            singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

        singleThreadPool.shutdown();
    }
}
