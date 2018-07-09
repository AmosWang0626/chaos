package cn.amos.mode.design.proxy;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Person implements Subject {

    @Override
    public void sendFlower() {
        System.out.println("【Real】送花");
    }
}
