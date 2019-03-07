package cn.amos.mode.design.proxy.jdk;

import cn.amos.mode.design.proxy.jdk.cook.Cook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

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
        System.out.println(MessageFormat.format("开始做饭，食材{0}, 开始 {1} ...",
                Arrays.toString(args), method.getName()));

        System.out.println("------------core----------------");
        Object invoke = method.invoke(cook, args);
        System.out.println("------------core----------------");

        System.out.println("做饭完成!");

        return invoke;
    }
}
