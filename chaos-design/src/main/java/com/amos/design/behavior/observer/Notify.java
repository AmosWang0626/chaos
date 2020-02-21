package com.amos.design.behavior.observer;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/16
 */
public interface Notify {

    /**
     * 发布通知
     *
     * @param msg 消息
     */
    default void notifyMsg(String msg) {
        System.out.println(this.getClass().getSimpleName() + "\t" + msg);
    }

}
