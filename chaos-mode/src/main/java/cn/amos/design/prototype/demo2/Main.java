package cn.amos.design.prototype.demo2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 原型模式 - 浅克隆
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
        System.out.println("person: " + person.display());
        System.out.println(person.work);

        Person clone1 = person.clone();
        clone1.setUserInfo(2L, "DAOYUAN");
        person.setWorkInfo("2016-07", "meituan");
        System.out.println("clone1: " + clone1.display());
        System.out.println(clone1.work);

    }
}
