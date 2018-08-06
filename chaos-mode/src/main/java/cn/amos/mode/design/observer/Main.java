package cn.amos.mode.design.observer;

/**
 * PROJECT: chaos
 * DESCRIPTION: 观察者模式
 *
 * @author DaoYuanWang
 * @date 2018/7/16
 */
public class Main {

    public static void main(String[] args) {
        Manage manage = new Manage();
        manage.addPerson(new Person1());
        manage.addPerson(new Person2());
        manage.addPerson(new Person3());
        manage.notifyMsg(" hello");
    }
}
