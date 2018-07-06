package cn.amos.design.proxy;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Main {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Person());
        proxy.sendFlower();
    }
}
