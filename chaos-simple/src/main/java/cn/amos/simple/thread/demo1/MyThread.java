package cn.amos.simple.thread.demo1;

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
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
