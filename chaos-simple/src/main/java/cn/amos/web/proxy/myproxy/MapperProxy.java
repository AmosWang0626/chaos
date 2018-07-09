package cn.amos.web.proxy.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MapperProxy implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {

		System.out.println("ͨ���ӿ���method��ȡ��Ӧ������Ϣ");
		System.out.println("�ӿ���.������==namespace.id");
		System.out.println("����SQL������͵�����ɾ�Ĳ�");
		System.out.println("���ǲ�ѯ�����жϷ���ֵ���ͣ����ò�ͬ����");

		// ģ������
		List<String> strList = new ArrayList<String>();
		strList.add("������");
		strList.add("������");
		strList.add("������");

		return strList;
	}

}
