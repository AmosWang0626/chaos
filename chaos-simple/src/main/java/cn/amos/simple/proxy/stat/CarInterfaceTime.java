package cn.amos.simple.proxy.stat;

/**
 * ʵ�ֽӿڵķ�ʽʵ��ʱ�����
 * 
 * @author Amos
 *
 */
public class CarInterfaceTime implements Moveable {

	private Moveable car;

	public CarInterfaceTime(Moveable car) {
		this.car = car;
	}

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time:" + startTime);
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("End Time:" + endTime + "  [Move Time:" + (endTime - startTime) + "]");
	}

}
