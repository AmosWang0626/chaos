package cn.amos.simple.thread;

public class ThreadBase implements Runnable {

	public static void main(String[] args) {

		Thread thread = new Thread(new ThreadBase());
		thread.start();

	}

	@Override
	public void run() {
		System.out.println("����һ���̳߳ɹ�!");
	}

}
