package cn.amos.web.proxy.myproxy;

import java.lang.reflect.Proxy;

public class SqlSession {

	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> type) {

		System.out.println("\n���������ļ����ɵ�Mapper����");
		System.out.println("�ҵ���" + (type.getName()) + "��Ӧ��Mapper");
		System.out.println("���ҵ���MapperProxy�෵�ػ�ȥ\n");

		return (T) Proxy.newProxyInstance(type.getClassLoader(),
				new Class[] { type }, new MapperProxy());
	}

}
