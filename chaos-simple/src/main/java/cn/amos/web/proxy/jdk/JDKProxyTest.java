package cn.amos.web.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.amos.web.proxy.stat.Car;
import cn.amos.web.proxy.stat.Moveable;

public class JDKProxyTest {

	public static void main(String[] args) {

		Car car = new Car();
		Class<?> cls = car.getClass();

		// �Զ�����TimeHandler
		InvocationHandler handler = new TimeHandler(car);

		/**
		 * Proxy.newProxyInstance(loader,interfaces, handler);
		 * loader:�������;interfaces:ʵ�ֵĽӿ�;handler:InvocationHandler.<br>
		 * �����������ʵ��
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);

		// ִ�нӿڷ���
		m.move();
	}

}
