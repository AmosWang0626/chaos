package cn.amos.mode.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * 使用CGLib实现动态代理，完全不受代理类必须实现接口的限制，
 * 而且CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，比使用Java反射效率要高。
 * 唯一需要注意的是，CGLib不能对声明为final的方法进行代理，因为CGLib原理是动态生成被代理类的子类。
 *
 * @author Amos
 */
public class CglibProxy implements MethodInterceptor {

    Object getProxy(Class<?> clazz) {
        /*
         * Enhancer 字节码增强器, 方便类拓展
         * 1.Enhancer允许为非接口类型创建一个Java代理;
         * 2.Enhancer动态创建了给定类型的子类, 但是拦截了所有的方法;
         * 3.和Proxy不一样的是, 不管是接口还是类, ta都能正常工作;
         */
        Enhancer enhancer = new Enhancer();
        // 设置代理目标
        enhancer.setSuperclass(clazz);

        /**
         * 设置回调地址
         * @see CglibProxy#intercept(Object, Method, Object[], MethodProxy)
         */
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method m, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println(MessageFormat.format("代理方法 {0}({1}) 开始执行 ......", m.getName(), Arrays.toString(args)));
        proxy.invokeSuper(obj, args);
        System.out.println(MessageFormat.format("代理方法 {0} 执行完成.", m.getName()));

        return null;
    }

}
