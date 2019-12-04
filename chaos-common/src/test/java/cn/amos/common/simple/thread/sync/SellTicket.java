package cn.amos.common.simple.thread.sync;

/**
 * PROJECT: chaos
 * NOTE: 售票
 *
 * @author AMOS
 * @date 2018/8/13 13:31
 */
public class SellTicket implements Runnable {
    private static int TOTAL = 150;

    public static void main(String[] args) throws InterruptedException {
        SellTicket sellTicket = new SellTicket();
        Thread thread1 = new Thread(sellTicket, "T1");
        Thread thread2 = new Thread(sellTicket, "T2");
        Thread thread3 = new Thread(sellTicket, "T3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "出售第" + (TOTAL--) + "张票!");
            }
        }
    }
}
