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
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}
