package cn.amos.mode.design.proxy.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 真实要送花人
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class RealPerson implements Subject {

    @Override
    public void sendFlower() {
        System.out.println("\t真实送花人要送一枝玫瑰花");
    }
}
