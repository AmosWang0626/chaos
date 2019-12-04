package cn.amos.common.simple.thread.others;

/**
 * @author AmosWang
 */
public class PriorityDemo {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("This Thread's Priority " + this.getPriority());
        }
    }

    public static void main(String[] args) {
        // new MyThread() 设置低优先级 先启动
        MyThread lowPriority = new MyThread();
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        lowPriority.start();
        // 设置高优先级 后启动
        MyThread highPriority = new MyThread();
        highPriority.setPriority(Thread.MAX_PRIORITY);
        highPriority.start();

        // 看输出 (说明: 优先级有用 /xk/xk)
        // This Thread's Priority 10
        // This Thread's Priority 1
    }
}
