package cn.amos.common.simple.thread.others;

/**
 * @author AmosWang
 */
public class VolatileTest2 {

    private static int count;
    private static volatile boolean ready = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!ready) {
                System.out.println(count);
            }
        }).start();

        Thread.sleep(1000);

        count = 88;
        ready = false;
    }

}
