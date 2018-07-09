package cn.amos.web.thread;

public class RunableTest implements Runnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new RunableTest());
        thread.start();

    }

    @Override
    public void run() {
        System.out.println("创建一个线程成功!");
    }

}
