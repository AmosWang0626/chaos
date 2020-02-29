package com.amos.advanced.thread.sync;

/**
 * PROJECT: interview
 * DESCRIPTION: 对象锁 --- 方法锁
 *
 * @author Daoyuan
 * @date 2019/3/29
 */
public class SyncObjectMethodLock implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        SyncObjectMethodLock instance = new SyncObjectMethodLock();

        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Finish!!!");
    }

    @Override
    public void run() {
        method();
    }

    private synchronized void method() {
        System.out.println("对象锁 >>> 方法锁 By " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成 By " + Thread.currentThread().getName());
    }

}
