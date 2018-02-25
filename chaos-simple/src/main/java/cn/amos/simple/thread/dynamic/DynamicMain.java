package cn.amos.simple.thread.dynamic;

import cn.amos.simple.thread.base.BaseCar;
import cn.amos.simple.thread.base.CarInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicMain {

    public static void main(String[] args) {

        BaseCar baseCar = new BaseCar(); // 接口实现类
        Class<?> cls = baseCar.getClass(); // 获得接口的class

        InvocationHandler handler = new TimeHandler(baseCar);
        /*
         * loader, 类加载器
         * interfaces, 实现的接口
         * h ,InvocationHandler
         */
        CarInterface m = (CarInterface) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), handler);
        m.move();

        // 输出生成代理类的名字
        System.out.println(m.getClass().getName());
    }

}
