package com.amos.advanced.thread.sync;

/**
 * PROJECT: interview
 * DESCRIPTION: 类锁 --- 静态方法锁
 *
 * @author Daoyuan
 * @date 2019/3/29
 */
public class SyncClassLock implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SyncClassLock());
        Thread t2 = new Thread(new SyncClassLock());

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

    private void method() {
        synchronized (SyncClassLock.class) {
            System.out.println("类锁 >>> .class lock! By " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完成 By " + Thread.currentThread().getName());
        }
    }

}
