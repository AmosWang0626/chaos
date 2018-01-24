package cn.amos.simple.test;

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
        oldClass();
    }
}
