package cn.amos.simple.proxy.stat;

/**
 * �̳еķ�ʽʵ��ʱ�����
 * 
 * @author Amos
 *
 */
public class CarExtend extends Car {

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time:" + startTime);
		super.move();
		long endTime = System.currentTimeMillis();
		System.out.println("End Time:" + endTime + "  [Move Time:" + (endTime - startTime) + "]");
	}

}
