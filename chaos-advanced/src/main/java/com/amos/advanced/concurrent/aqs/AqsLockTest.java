package com.amos.advanced.concurrent.aqs;

/**
 * DESCRIPTION: MyAqsLock 测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/12
 * @see MyAqsLock 自定义锁
 */
public class AqsLockTest {

    private MyAqsLock aqsLock = new MyAqsLock();

    private int num;

    public int next() {
        /// return num++;

        aqsLock.lock();
        try {
            return num++;
        } finally {
            aqsLock.unlock();
        }
    }

    public static void main(String[] args) {
        AqsLockTest test = new AqsLockTest();

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> System.out.println(test.next()));
            threads[i].start();
        }

    }

}
