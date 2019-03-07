package cn.amos.mode.design.proxy.jdk;

import cn.amos.mode.design.proxy.jdk.cook.Cook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String name = new Random().nextBoolean() ?
                "cn.amos.mode.design.proxy.jdk.cook.CookPizza" : "cn.amos.mode.design.proxy.jdk.cook.CookPizza";
        Class clz = Class.forName(name);
        InvocationHandler handler = new JdkProxy((Cook) clz.newInstance());
        Cook cook = (Cook) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), handler);
        cook.cooking("AAA", "BBB");
    }

}
