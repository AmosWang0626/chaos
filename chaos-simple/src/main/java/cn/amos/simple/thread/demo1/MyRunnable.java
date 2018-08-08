package cn.amos.simple.thread.demo1;

/**
 * PROJECT: chaos
 * DESCRIPTION: 实现Runnable方式实现
 *
 * @author DaoYuanWang
 * @date 2018/7/17
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " Hello Runnable!");
    }

    public static void main(String[] args) throws Exception {
        // 一个线程哪够，来仨(sa)...
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
    }

    private static void simple() throws Exception {
        new Thread(() -> System.out.println(Thread.currentThread().getId() + " Hello Runnable!")).start();
        new Thread(() -> System.out.println(Thread.currentThread().getId() + " Hello Runnable!")).start();
        new Thread(() -> System.out.println(Thread.currentThread().getId() + " Hello Runnable!")).start();
    }

}
