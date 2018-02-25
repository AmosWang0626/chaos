package cn.amos.simple.observer;

import java.util.ArrayList;
import java.util.List;

public class ObsSentinel implements ObServer {

	private List<Student> stuList;
	private String name;

	public ObsSentinel(String name) {
		this.name = name;
		stuList = new ArrayList<Student>();
	}

	@Override
	public void addStu(Student stu) {
		stuList.add(stu);
	}

	@Override
	public void deleteStu(Student stu) {
		stuList.remove(stu);
	}

	@Override
	public void notifyStudent() {
		System.out.println("����" + name + "�۲���");

		for (Object obj : stuList) {
			((Student) obj).Notice();
		}

	}

}
