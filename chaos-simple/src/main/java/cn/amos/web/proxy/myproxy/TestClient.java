package cn.amos.web.proxy.myproxy;

import java.util.List;

public class TestClient {

	public static void main(String[] args) {
		System.out.println("���ȼ��������ļ�");
		System.out.println("���������ļ�����Mapper�Ĺ���");

		SqlSession sqlSession = new SqlSession();
		MyInterface myInterface = sqlSession.getMapper(MyInterface.class);
		List<Object> list = myInterface.getMessageAll();

		System.out.println("\ngetMessageAll()�������������" + list.size() + "��");
	}

}
