package cn.amos.simple.test;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: demo-java
 * DATE: 2018/1/5
 *
 * @author DaoYuanWang
 */
public class TestClass {
    private static void oldClass() {
        String mockEnv = "";
        String thisEnv = "TEST";
        System.out.println(mockEnv.contains(thisEnv));
    }

    public static void main(String[] args) {
//        oldClass();
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.forEach(System.out::println);
    }
}
