package cn.amos.common.simple.thread.achieve;

/**
 * PROJECT: chaos
 * DESCRIPTION: 继承Thread方式实现
 *
 * @author DaoYuanWang
 * @date 2018/7/17
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " Hello Thread!");
    }

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
