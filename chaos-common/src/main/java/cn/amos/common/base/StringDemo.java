package cn.amos.common.base;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote String Test Demo
 * @date 2018/1/5
 */
public class StringDemo {

    public static void main(String[] args) {
        String mockEnv = "";
        String thisEnv = "TEST";
        System.out.println(mockEnv.contains(thisEnv));
        System.out.println("test " + new StringDemo().hello() + " demo!");
    }

    protected String hello() {
        return "hello";
    }
}
