package cn.amos.simple.proxy.stat;

/**
 * ���Կͻ���
 */
public class StatTest {

	public static void main(String[] args) {
		StatTest client = new StatTest();
		client.proxyExtend();
	}

	/**
	 * ���ַ�ʽʵ�־�̬���� <br>
	 * 1.0 ͨ���̳�ʵ�־�̬���� <br>
	 * 2.0 ͨ���ۺ�ʵ�־�̬����
	 */
	public void proxyExtend() {

		new CarExtend().move();
	}

	public void proxyInterface() {

		new CarInterfaceTime(new Car()).move();
	}

	/**
	 * �þۺ�ʵ�ֹ�����չ���� <br>
	 * 1.0 �ȼ�¼��־ <br>
	 * 2.0 ���¼��־
	 */
	public void proxyLogAndTime1() {

		Car car = new Car();

		CarInterfaceLog log1 = new CarInterfaceLog(car);
		CarInterfaceTime time1 = new CarInterfaceTime(log1);
		time1.move();
	}

	public void proxyLogAndTime2() {

		Car car = new Car();

		CarInterfaceTime time2 = new CarInterfaceTime(car);
		CarInterfaceLog log2 = new CarInterfaceLog(time2);
		log2.move();
	}

}
