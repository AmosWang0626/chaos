package cn.amos.common.simple.thread.sync;

/**
 * PROJECT: chaos
 * NOTE: 类说明
 *
 * @author AMOS
 * @date 2018/8/14 10:11
 */
public class SyncObject implements Runnable {

    @Override
    public void run() {
        // synchronized锁住的是对象,要想让这些线程依次执行,需要锁住整个类
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "开始执行!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行结束!");
        }
    }

    public static void main(String[] args) {
        SyncObject syncObject = new SyncObject();
        new Thread(syncObject, "T1").start();
        new Thread(syncObject, "T2").start();
        new Thread(syncObject, "T3").start();
    }
}
