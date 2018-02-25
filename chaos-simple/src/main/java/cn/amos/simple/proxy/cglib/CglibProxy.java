package cn.amos.simple.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglibʵ�ֶ�̬����
 * 
 * @author Amos
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<?> clazz) {
		// ���ô����������
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);

		return enhancer.create();
	}

	/**
	 * ��������Ŀ����ĵ���<br/>
	 * 1. obj Ŀ�����ʵ��<br/>
	 * 2. m Ŀ�귽���ķ������<br/>
	 * 3. args �����Ĳ���<br/>
	 * 4. proxy �������ʵ��<br/>
	 */
	@Override
	public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {

		System.out.println("��־��ʼ����");

		// ��������ø���ķ���
		proxy.invokeSuper(obj, args);

		System.out.println("��־����");
		return null;
	}

}
