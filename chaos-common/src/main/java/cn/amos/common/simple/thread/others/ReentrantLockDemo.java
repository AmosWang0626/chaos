package cn.amos.common.simple.thread.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 *
 * @author Daoyuan
 */
public class ReentrantLockDemo extends Thread {

    private static ReentrantLock lock = new ReentrantLock();

    private static int index = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                index++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo thread1 = new ReentrantLockDemo();
        ReentrantLockDemo thread2 = new ReentrantLockDemo();
        thread1.start();
        thread2.start();

        // 执行完下边两行, 再执行sout
        thread1.join();
        thread2.join();

        System.out.println(index);
    }
}
