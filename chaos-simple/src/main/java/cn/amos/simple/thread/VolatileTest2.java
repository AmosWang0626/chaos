package cn.amos.simple.thread;

public class VolatileTest2 {
    private static int count;
    private static volatile boolean ready = true;

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        count = 88;
        ready = false;
        Thread.sleep(8000);
    }

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready)
                System.out.println(count);
        }
    }
}