package cn.amos.simple.thread;

public class SyncTest implements Runnable {

    // static SyncTest syncTest = new SyncTest();
    static int count = 0;

    private static synchronized void increase() {
        count++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            // 第一种方法
            /*synchronized (syncTest) { // 这句话非常重要
                count++;
            }*/
            // 第二种方法
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /*Thread thread1 = new Thread(syncTest);
        Thread thread2 = new Thread(syncTest);*/
        Thread thread1 = new Thread(new SyncTest());
        Thread thread2 = new Thread(new SyncTest());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
