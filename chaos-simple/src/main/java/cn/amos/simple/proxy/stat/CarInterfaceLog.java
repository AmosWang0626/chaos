package cn.amos.simple.proxy.stat;

/**
 * ʵ�ֽӿڵķ�ʽʵ����־����
 * 
 * @author Amos
 *
 */
public class CarInterfaceLog implements Moveable {

	private Moveable car;

	public CarInterfaceLog(Moveable car) {
		this.car = car;
	}

	@Override
	public void move() {
		System.out.println("��ʼ��¼��־");
		car.move();
		System.out.println("������¼��־");
	}

}
