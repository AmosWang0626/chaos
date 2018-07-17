package cn.amos.simple.thread.others;

/**
 * @author AmosWang
 */
public class JoinDemo {

    /**
     * Thread.yield();
     * 它是一个静态方法, 一旦执行就让当前进程让出CPU,
     * 它让出CPU之后,还会进程CPU资源的争夺, 但不一定能分配到
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("线程休眠1秒钟完成!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        // 加入join()之后, 后续操作会等待当前线程执行完成后再执行

        // 效果: 注释下边这行代码看输出
        myThread.join();
        System.out.println("程序执行完成!");
    }
}
