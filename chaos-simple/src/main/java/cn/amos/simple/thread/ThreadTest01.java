package cn.amos.simple.thread;

public class ThreadTest01 extends Thread {

	private int id = 10;

	public ThreadTest01(String threadName) {
		super(threadName);
	}

	public static void main(String[] args) {
		Thread thread1 = new ThreadTest01("��Ʊ��1");
		Thread thread2 = new ThreadTest01("��Ʊ��2");
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		super.run();
		while (id > 0) {
			if (id > 0) {
				System.out.println(Thread.currentThread().getName() + "�۳���"
						+ (id--) + "��Ʊ");
			}
		}
	}

}
