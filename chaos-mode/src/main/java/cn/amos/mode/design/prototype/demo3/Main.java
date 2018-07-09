package cn.amos.mode.design.prototype.demo3;

/**
 * PROJECT: chaos
 * DESCRIPTION: 原型模式 - 深复制
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setUserInfo(1L, "AMOS");
        person.setWorkInfo(new Work("2016-07", "meituan"));

        try {
            Person clone1 = (Person) person.clone();
            clone1.setUserInfo(2L, "DAOYUAN");
            clone1.setWorkInfo(new Work("2017-07", "1-cash"));

            System.out.println("person: " + person.display());
            System.out.println("clone1: " + clone1.display());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
