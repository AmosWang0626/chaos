package cn.amos.simple.thread.others;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/18
 */
public class DeadLock {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("暂停 " + thread.getName());
        thread.suspend();
        int millis = 2000;
        System.out.println("主线程sleep " + millis + "毫秒");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("恢复 " + thread.getName());
        thread.resume();
        System.out.println("主线程结束");
    }
}
