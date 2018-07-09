package cn.amos.web.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��������
 * 
 * @author Amos
 *
 */
public class TimeHandler implements InvocationHandler {

	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	/**
	 * ����:proxy:������Ķ���;method:���������ķ���;args:�����Ĳ���.
	 * 
	 * ����ֵ:Object �����ķ���ֵ
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// 1. �Զ���Ŀ�ʼǰ�����߼�
		long startTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺" + startTime);

		// 2. �˴��õ���Java�ķ������ ������󣬷������ִ�ж�����ķ���
		method.invoke(target);

		// 3. �Զ���Ľ���ʱ�����߼�
		long endTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺" + endTime + "  [����ʻ" + (endTime - startTime) + "����]");

		return null;
	}

}
