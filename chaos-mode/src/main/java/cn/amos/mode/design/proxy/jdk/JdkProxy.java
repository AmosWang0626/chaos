package cn.amos.mode.design.proxy.jdk;

import cn.amos.mode.design.proxy.jdk.cook.Cook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class JdkProxy implements InvocationHandler {

    private Cook cook;

    JdkProxy(Cook cook) {
        this.cook = cook;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备工作...");

        Object invoke = method.invoke(cook);
        System.out.println("开始制作: " + invoke);

        System.out.println("制作完成...");

        return invoke;
    }
}
