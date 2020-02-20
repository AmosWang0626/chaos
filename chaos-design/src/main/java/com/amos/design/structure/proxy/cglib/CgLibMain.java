package com.amos.design.structure.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.text.MessageFormat;

/**
 * NOTE: 利用 Cglib 实现的动态代理 --> 执行方法
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class CgLibMain {

    /**
     * Enhancer 即(字节码)增强器
     * 它是CGLIB库中最常用的一个类，功能JDK动态代理中引入的Proxy类差不多，但是Enhancer既能够代理普通的Java类，也能够代理接口。
     * callback
     * >>> NoOp                 什么都不做
     * >>> FixedValue           返回固定值 [返回值并不能转换成原方法的返回值类型，就会抛出类型转换异常（ClassCastException）]
     * >>> InvocationHandler    所有对invoke方法的参数proxy对象的方法调用都会被委托给同一个InvocationHandler，所以可能会导致无限循环(因为invoke中调用的任何原代理类方法，均会重新代理到invoke方法中)
     * >>> MethodInterceptor    即方法拦截器，这是一个功能很强大的接口，它可以实现类似于AOP编程中的环绕增强（Around Advice）
     * >>> Dispatcher
     * >>> LazyLoader
     */
    public static void main(String[] args9) {
        Enhancer enhancer = new Enhancer();
        // 代理核心 callback
        enhancer.setCallback(methodCallback());
        // @see CallbackFilter
        // enhancer.setCallbacks(new Callback[]{...});

        // 有参构造创建对象
        enhancer.setSuperclass(RealDriver.class);
        RealDriver driver = (RealDriver) enhancer.create(new Class[]{String.class}, new Object[]{"刘易斯·汉密尔顿"});

        // 无参构造创建对象
        // enhancer.setSuperclass(VirtualDriver.class);
        // VirtualDriver driver = (VirtualDriver) enhancer.create();

        String drive = driver.drive("EQ Silver Arrow 01");

        System.out.println("\n比赛感受：" + drive);
    }

    private static MethodInterceptor methodCallback() {
        return (o, method, args, methodProxy) -> {
            System.out.println(MessageFormat.format("经纪公司 {0} 安排赛程...",
                    Thread.currentThread().getStackTrace()[2].getClassName()));

            // method调用效率比较高
            Object invoke = methodProxy.invokeSuper(o, args);

            System.out.println("赛程数据统计等等");

            return invoke;
        };
    }

}
