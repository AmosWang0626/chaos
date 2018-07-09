package cn.amos.simple.thread;

public class ThreadTest02 implements Runnable {

	private int id = 10;

	public static void main(String[] args) {
		ThreadTest02 tr = new ThreadTest02();
		Thread thread1 = new Thread(tr, "��Ʊ��1");
		Thread thread2 = new Thread(tr, "��Ʊ��2");

		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		while (id > 0) {
			if (id > 0) {
				System.out.println(Thread.currentThread().getName() + "�۳���"
						+ (id--) + "��Ʊ");
			}
		}
	}

}
