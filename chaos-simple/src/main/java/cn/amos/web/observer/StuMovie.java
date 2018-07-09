package cn.amos.web.observer;

public class StuMovie implements Student {

	private String name;

	public StuMovie(String name) {
		this.name = name;
	}

	@Override
	public void Notice() {
		System.out.print("����Ӱ��");
		System.out.println(name + "ͬѧ,��ʦ����Ŷ!");

	}

}
