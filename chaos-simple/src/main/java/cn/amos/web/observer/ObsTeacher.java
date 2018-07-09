package cn.amos.web.observer;

import java.util.ArrayList;
import java.util.List;

public class ObsTeacher implements ObServer {

	private List<Student> stuList;
	private String name;

	public ObsTeacher(String name) {
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

		System.out.println("����" + name + "��ʦ");

		for (Object obj : stuList) {
			((Student) obj).Notice();
		}

	}

}
