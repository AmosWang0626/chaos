package com.amos.advanced.thread.aqs;

/**
 * DESCRIPTION: MyAqsLock 测试锁的可重入
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 * @see MyAqsLock 自定义锁
 */
public class AqsLockTest2 {

    private MyAqsLock aqsLock = new MyAqsLock();

    private int num;

    /**
     * 测试锁的可重入性
     */
    public int method1() {
        aqsLock.lock();
        try {
            return method2();
        } finally {
            aqsLock.unlock();
        }
    }

    public int method2() {
        aqsLock.lock();
        try {
            return num++;
        } finally {
            aqsLock.unlock();
        }
    }

    public static void main(String[] args) {
        AqsLockTest2 test = new AqsLockTest2();

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> System.out.println(test.method1()));
            threads[i].start();
        }

    }

}
