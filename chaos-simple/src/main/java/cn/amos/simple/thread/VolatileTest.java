package cn.amos.simple.thread;

public class VolatileTest implements Runnable {
    private static volatile int count = 0;

    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new VolatileTest());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println("执行结束:" + count);
    }
}
