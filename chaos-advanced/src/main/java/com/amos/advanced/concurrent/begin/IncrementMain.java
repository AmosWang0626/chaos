package com.amos.advanced.concurrent.begin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 模块名称: chaos
 * 模块描述: 并发-线程安全
 *
 * @author amos.wang
 * @date 2020/12/8 14:08
 */
public class IncrementMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(IncrementMain.class);

    public static void main(String[] args) {
        IncrementData incrementData = new IncrementData();

        final int size = 500;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);

        Thread[] planThreads = new Thread[size];
        for (int i = 0; i < size; i++) {
            planThreads[i] = new Thread(() -> {
                try {
                    LOGGER.info("线程 [{}] 准备就绪 ...", Thread.currentThread().getId());
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                LOGGER.info("线程 [{}] 开始执行递增逻辑，执行结果：[{}]", Thread.currentThread().getId(), incrementData.increment());
            });
            planThreads[i].start();
        }
    }

}
