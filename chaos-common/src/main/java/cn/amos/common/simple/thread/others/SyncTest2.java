package cn.amos.common.simple.thread.others;

/**
 * @author AmosWang
 */
public class SyncTest2 implements Runnable {

    private static final SyncTest2 SYNC_TEST_2 = new SyncTest2();

    /**
     * 测试用自增id
     */
    private static int count = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            // 第一种方法
            synchronized (SYNC_TEST_2) {
                count++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(SYNC_TEST_2);
        Thread thread2 = new Thread(SYNC_TEST_2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
