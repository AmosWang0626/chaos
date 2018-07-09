package cn.amos.mode.design.prototype.demo1;

/**
 * PROJECT: chaos
 * DESCRIPTION: 原型模式 - 第一版clone
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
        person.setWorkInfo("2017-07", "1-cash");

        try {
            Person clone1 = (Person) person.clone();
            clone1.setUserInfo(2L, "DAOYUAN");

            System.out.println("person: " + person.display());
            System.out.println("person Object: " + person);

            System.out.println("\nclone1: " + clone1.display());
            System.out.println("clone1 Object: " + clone1);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
