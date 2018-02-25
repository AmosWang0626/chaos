package cn.amos.simple.thread.base;

import java.util.ArrayList;
import java.util.List;

public class IsEmpty {

	public static void main(String[] args) {
		List<Object> list;
		// System.out.println("List is null,and isEmpty ? " + list.isEmpty());
		// The List will throw NullPointerException;
		list = new ArrayList<Object>();
		System.out.println("List init isEmpty ? " + list.isEmpty());
		list.add("Hello Amos!");
		list.add("Welcome to Java World!");
		System.out.println("List have data,and isEmpty ? " + list.isEmpty());
		System.out.println("isEmpty() equivalent to (list.size() == 0)");
	}

}
