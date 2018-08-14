package cn.amos.common.simple.thread.sync;

/**
 * PROJECT: chaos
 * NOTE:
 * <p>
 * 有意思的demo，使用wait notify的方法一定要加synchronized
 * - @see WaitNotifyTest#testNotify() 完全执行完，才会去执行上次wait之后的,这个可能得益于synchronized
 * </p>
 *
 * @author AMOS
 * @date 2018/8/14 10:27
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();
        new Thread(() -> waitNotifyTest.testWait()).start();
        new Thread(() -> waitNotifyTest.testNotify()).start();
    }

    private synchronized void testWait() {
        System.out.println("111");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("222");
        System.out.println("333");
    }

    private synchronized void testNotify() {
        this.notify();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("444");
        System.out.println("555");
    }
}
