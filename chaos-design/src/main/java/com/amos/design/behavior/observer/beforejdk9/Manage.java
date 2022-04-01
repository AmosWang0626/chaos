package com.amos.design.behavior.observer.beforejdk9;

import java.util.Observable;

/**
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/16
 */
public class Manage extends Observable {

    public void notifyMsg(String msg) {
        System.out.println("通知小伙伴们～");
        this.setChanged();
        this.notifyObservers(msg);
    }

}
