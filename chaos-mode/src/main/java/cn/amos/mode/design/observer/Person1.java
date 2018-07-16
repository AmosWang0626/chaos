package cn.amos.mode.design.observer;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/16
 */
public class Person1 implements InterNotify {

    @Override
    public void notifyMsg(String msg) {
        System.out.println(this.getClass().getSimpleName() + msg);
    }
}
