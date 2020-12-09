package com.amos.advanced.concurrent.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * DESCRIPTION: AQS DEMO
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 */
public class MyAqsLock implements Lock {

    /**
     * 自定义 AbstractQueuedSynchronizer Lock
     */
    private AbsQueueSyncImpl absQueueSync = new AbsQueueSyncImpl();

    /**
     * 当前锁的信号量（自定义）
     */
    private static final int SIGNAL = 6;


    @Override
    public void lock() {
        absQueueSync.acquire(SIGNAL);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        absQueueSync.acquireInterruptibly(SIGNAL);
    }

    @Override
    public boolean tryLock() {
        return absQueueSync.tryAcquire(SIGNAL);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return absQueueSync.tryAcquireNanos(SIGNAL, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        absQueueSync.release(SIGNAL);
    }

    @Override
    public Condition newCondition() {
        return absQueueSync.newConditionObject();
    }


    /**
     * 自己实现 AbstractQueuedSynchronizer
     */
    private static class AbsQueueSyncImpl extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            // 注意嵌套锁引起的死锁，处理思路就是兼容锁的可重入性
            Thread current = Thread.currentThread();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {
                setState(state + arg);
                return true;
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int state = getState() - arg;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                setState(state);
                return true;
            }

            // 此处不存在线程安全问题，原因是能走到这里的线程是独占的
            setState(state);

            return false;
        }

        public Condition newConditionObject() {
            return new ConditionObject();
        }

    }

}
