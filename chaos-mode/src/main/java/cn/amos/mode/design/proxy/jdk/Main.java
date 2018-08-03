package cn.amos.mode.design.proxy.jdk;

import cn.amos.mode.design.proxy.jdk.cook.Cook;
import cn.amos.mode.design.proxy.jdk.cook.CookPizza;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class Main {

    public static void main(String[] args) {
        Cook pizza = new CookPizza();
        Class<?> clz = pizza.getClass();

        InvocationHandler handler = new JdkProxy(pizza);

        Cook cook = (Cook) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), handler);

        cook.production();
    }
}
