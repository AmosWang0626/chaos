package cn.amos.simple.observer;

public class Main {

	public static void main(String[] args) {
		Student stu1, stu2, stu3;
		stu1 = new StuPlay("��**");
		stu2 = new StuMovie("��**");
		stu3 = new StuPlay("��**");

		ObServer obs = new ObsSentinel("֣*");
		ObServer obs2 = new ObsTeacher("��*");
		obs.addStu(stu1);
		obs.addStu(stu2);
		obs.addStu(stu3);

		obs2.addStu(stu1);
		obs2.addStu(stu2);
		obs2.addStu(stu3);

		obs.notifyStudent();
		System.out.println("**************************");
		obs2.notifyStudent();
	}

}
