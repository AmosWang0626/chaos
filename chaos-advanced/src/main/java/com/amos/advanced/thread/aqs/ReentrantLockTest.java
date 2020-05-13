package com.amos.advanced.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * DESCRIPTION: ReentrantLock 锁测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 */
public class ReentrantLockTest {

    /**
     * 单词: fair公平
     * 公平锁 [FairSync] || 非公平锁 [NonfairSync]
     * 默认为非公平锁 NonfairSync
     */
    ReentrantLock nonFairLock = new ReentrantLock();

    ReentrantLock fairLock = new ReentrantLock(true);

    public void test() {
        nonFairLock.lock();
        try {
            logic();
        } finally {
            nonFairLock.unlock();
        }
    }

    public void test2() {
        fairLock.lock();
        try {
            logic();
        } finally {
            fairLock.unlock();
        }
    }

    public void logic() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException("[ERROR] :: sleep error");
        }
    }

    public static void main(String[] args) {

    }

}
