package com.amos.advanced.thread.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * DESCRIPTION: 读写锁测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 */
public class ReadWriteLockTest {

    /**
     * 默认为不公平锁
     */
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest lockTest = new ReadWriteLockTest();

        // 获取读锁
        ReentrantReadWriteLock.ReadLock readLock = lockTest.reentrantReadWriteLock.readLock();
        // 获取写锁
        ReentrantReadWriteLock.WriteLock writeLock = lockTest.reentrantReadWriteLock.writeLock();

        writeLock.lock();

        // ReentrantReadWriteLock 仅支持锁降级，不支持锁升级
        // 锁降级: 写锁 >>> 读锁
        // 写完了，释放写锁前，要先加读锁
        readLock.lock();
        writeLock.unlock();

        // 锁升级: 读锁 >>> 写锁
        readLock.unlock();
        writeLock.lock();

    }

    /**
     * 自定义锁
     */
    ReadWriteLock readWriteLock = new ReadWriteLock() {
        @Override
        public Lock readLock() {
            return null;
        }

        @Override
        public Lock writeLock() {
            return null;
        }
    };

}
