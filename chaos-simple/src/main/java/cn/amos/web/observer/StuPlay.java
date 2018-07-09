package cn.amos.web.observer;

public class StuPlay implements Student {

	private String name;

	public StuPlay(String name) {
		this.name = name;
	}

	@Override
	public void Notice() {
		System.out.print("����Ϸ��");
		System.out.println(name + "ͬѧ,��ʦ����Ŷ!");

	}

}
