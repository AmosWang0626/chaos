package com.amos.design.behavior.observer;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 观察者
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        Manage manage = new Manage();
        manage.addPerson(new Persons.Person1());
        manage.addPerson(new Persons.Person2());
        manage.addPerson(new Persons.Person3());

        manage.notifyMsg("嘘，老板来了。");        
    }

}
