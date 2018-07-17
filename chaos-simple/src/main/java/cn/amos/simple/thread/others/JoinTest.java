package cn.amos.simple.thread.others;

public class JoinTest {

    private volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 1000000; i++) {
                /*
                 它是一个静态方法,
                 一旦执行就让当前进程让出CPU,
                 它让出CPU之后,还会进程CPU资源的争夺,
                 但不一定能分配到
                 */
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join(); // join()是比较友好的,它在它之前的线程执行完后执行
        System.out.println(i);
    }
}
