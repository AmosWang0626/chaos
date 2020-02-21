package com.amos.design.creation.prototype.deep;


import java.time.LocalDate;

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
        person.setWorkInfo(new Work(LocalDate.of(2017, 7, 23), "1-cash"));

        try {
            Person clone = (Person) person.clone();
            clone.setUserInfo(2L, "DaoYuan");
            clone.setWorkInfo(new Work(LocalDate.of(2019, 4, 8), "xiao-i"));

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
