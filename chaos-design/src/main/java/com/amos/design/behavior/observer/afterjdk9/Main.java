package com.amos.design.behavior.observer.afterjdk9;

/**
 * 设计模式 —— 观察者
 * 借助 java.util.concurrent.Flow 相关API实现的观察者模式
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        Manage manage = new Manage();

        try (manage) {
            manage.subscribe(new Persons.Person1());
            manage.subscribe(new Persons.Person2());
            manage.subscribe(new Persons.Person3());
            manage.submit("嘘，老板来了。");
            Thread.currentThread().join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
