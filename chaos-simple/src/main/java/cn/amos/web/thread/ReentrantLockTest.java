package cn.amos.web.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        Thread thread1 = new Thread(lockTest);
        Thread thread2 = new Thread(lockTest);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
