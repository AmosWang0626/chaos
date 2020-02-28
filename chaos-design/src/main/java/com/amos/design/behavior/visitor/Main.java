package com.amos.design.behavior.visitor;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 访问者
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        PersonStruct struct = new PersonStruct();
        struct.add(new Persons.Man());
        struct.add(new Persons.Woman());

        struct.execute(new Visitors.VisitorSuccess());
        struct.execute(new Visitors.VisitorLove());
    }

}
