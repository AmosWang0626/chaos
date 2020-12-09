package com.amos.advanced.concurrent.sync;

/**
 * PROJECT: interview
 * DESCRIPTION: 对象锁 --- 代码块锁
 *
 * @author Daoyuan
 * @date 2019/3/28
 */
public class SyncObjectCodeBlock implements Runnable {

    private static final Object lock = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        SyncObjectCodeBlock instance = new SyncObjectCodeBlock();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("Finish!!!");
    }

    @Override
    public void run() {
        // lock lock2 也可换成this
        synchronized (lock) {
            System.out.println("我是 11111 " + Thread.currentThread().getName() + " 对象锁的代码块形式 >>>");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">>> 11111 " + Thread.currentThread().getName() + " 运行结束");
        }
        synchronized (lock2) {
            System.out.println("我是 22222 " + Thread.currentThread().getName() + " 对象锁的代码块形式 >>>");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">>> 22222 " + Thread.currentThread().getName() + " 运行结束");
        }
    }
}
