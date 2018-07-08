package cn.amos.design.prototype.demo1;

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
        System.out.println("person: " + person.display());

        Person clone1 = person.clone();
        clone1.setUserInfo(2L, "DAOYUAN");
        System.out.println("clone1: " + clone1.display());

        // 原对象信息也发生变化
        System.out.println("person: " + person.display());
    }
}
