package cn.amos.simple.thread.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object obj, Method method) throws InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车启动……");
        System.out.println("出发咯");

        method.invoke(target);

        long endTime = System.currentTimeMillis();
        System.out.println("停车\t" + "[一共行驶" + (endTime - startTime) + "毫秒]");
    }
}
