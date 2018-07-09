package cn.amos.web.thread;

public class ThreadGroupTest implements Runnable {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("PrintGroup");
        Thread thread1 = new Thread(threadGroup, new ThreadGroupTest(), "Thread 1");
        Thread thread2 = new Thread(threadGroup, new ThreadGroupTest(), "Thread 2");
        thread1.start();
        thread2.start();

        // .activeCount() 获取活动线程总数
        System.out.println(threadGroup.activeCount());
        threadGroup.list();
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()
                + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
