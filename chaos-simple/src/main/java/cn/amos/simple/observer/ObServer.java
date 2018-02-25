package cn.amos.simple.observer;

public interface ObServer {

	public void addStu(Student stu);

	public void deleteStu(Student stu);

	public void notifyStudent();

}
