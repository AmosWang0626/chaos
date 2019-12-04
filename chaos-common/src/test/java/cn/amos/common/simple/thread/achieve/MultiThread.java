package cn.amos.common.simple.thread.achieve;

/**
 * PROJECT: chaos
 * DESCRIPTION: 多线程实践
 *
 * @author DaoYuanWang
 * @date 2018/7/17
 */
public class MultiThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()
                    + " This program running! Thread id is "
                    + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new MultiThread().start();
        new MultiThread().start();
        new MultiThread().start();
        new MultiThread().start();
        System.out.println("执行耗时: " + (System.currentTimeMillis() - startTime));
    }
}
