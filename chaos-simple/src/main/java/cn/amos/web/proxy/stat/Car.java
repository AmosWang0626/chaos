package cn.amos.web.proxy.stat;

import java.util.Random;

/**
 * ��ʵ������
 * 
 * @author Amos
 *
 */
public class Car implements Moveable {

	@Override
	public void move() {

		try {
			System.out.println("������ʻ�С���");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
