package com.amos.design.behavior.observer.beforejdk9;

/**
 * 设计模式 —— 观察者
 * 借助 java.util.Observer 相关API实现的观察者模式
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        Manage manage = new Manage();
        manage.addObserver(new Persons.Person1());
        manage.addObserver(new Persons.Person2());
        manage.addObserver(new Persons.Person3());

        manage.notifyMsg("嘘，老板来了。");
    }

}
