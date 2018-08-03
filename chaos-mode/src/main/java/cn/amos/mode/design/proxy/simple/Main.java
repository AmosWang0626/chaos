package cn.amos.mode.design.proxy.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 静态代理 --> 执行方法
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Main {

    public static void main(String[] args) {
        ProxyPerson proxyPerson = new ProxyPerson(new RealPerson());
        proxyPerson.sendFlower();
    }
}
