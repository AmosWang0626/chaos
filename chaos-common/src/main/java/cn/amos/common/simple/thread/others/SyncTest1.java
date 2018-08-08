package cn.amos.common.simple.thread.others;

/**
 * @author AmosWang
 */
public class SyncTest1 implements Runnable {

    /**
     * 测试用自增id
     */
    private static int count = 0;

    private static synchronized void increase() {
        count++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SyncTest1());
        Thread thread2 = new Thread(new SyncTest1());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
