package cn.amos.mode.design.prototype.demo2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 原型模式 - 浅复制
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Main {

    /**
     * 浅层复制
     */
    public static void main(String[] args) {
        Person person = new Person();
        person.setUserInfo(1L, "AMOS");
        person.setWorkInfo("2016-07", "meituan");

        try {
            Person clone1 = (Person) person.clone();
            clone1.setUserInfo(2L, "DAOYUAN");
            clone1.setWorkInfo("2017-07", "1-cash");

            System.out.println("person: " + person.display());
            System.out.println("clone1: " + clone1.display());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
