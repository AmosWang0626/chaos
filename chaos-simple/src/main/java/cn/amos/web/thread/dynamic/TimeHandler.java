package cn.amos.web.thread.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    // target 目标接口实现类
    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time:" + startTime);
        System.out.println("Car Moving...");

        method.invoke(target);

        long endTime = System.currentTimeMillis();
        System.out.println("End Time:" + endTime + "  [Move Time:"
                + (endTime - startTime) + "]");

        return null;
    }
}

/*
 * public Object invoke(Object proxy, Method method, Object[] args)
 *
 * 参数：<br/>
 * proxy 被代理的对象<br/>
 * method 被代理对象的方法<br/>
 * args 方法的参数
 *
 * 返回值：<br/>
 * Object 方法的返回值
 */
