package com.amos.design.creation.prototype.shallow;

import java.time.LocalDate;

/**
 * PROJECT: chaos
 * DESCRIPTION: 原型模式 - 浅复制
 *
 * @author DaoyuanWang
 * @date 2018/7/8
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setUserInfo(1L, "AMOS");
        person.setWorkInfo("2017-07", "1-cash");

        try {
            Person clone = (Person) person.clone();
            clone.setUserInfo(2L, "DaoYuan");
            clone.setWorkInfo("2019-04", "xiao-i");

            System.out.println("PERSON: " + person.display());
            System.out.println("OBJECT: " + person);
            System.out.println();
            System.out.println("CLONED: " + clone.display());
            System.out.println("OBJECT: " + clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
