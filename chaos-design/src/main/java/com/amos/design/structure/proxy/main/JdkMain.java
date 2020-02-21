package com.amos.design.structure.proxy.main;

import com.amos.design.structure.proxy.common.Drive;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Random;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: JDK 原生代理（java.lang.reflect）
 *
 * @author Daoyuan
 * @date 2019/3/8
 */
public class JdkMain {

    public static void main(String[] args9) {
        Drive driver;

        /// 获取要代理的类 方式一
        // driver = new Random().nextBoolean() ? new RealDriver("刘易斯·汉密尔顿") : new VirtualDriver();

        // 获取要代理的类 方式二
        driver = new Random().nextBoolean() ? newInstance("com.amos.design.structure.proxy.common.VirtualDriver")
                : newInstance("com.amos.design.structure.proxy.common.RealDriver", new Class[]{String.class}, new Object[]{"刘易斯·汉密尔顿"});
        Objects.requireNonNull(driver);

        Drive instance = (Drive) Proxy.newProxyInstance(
                driver.getClass().getClassLoader(), driver.getClass().getInterfaces(), (proxy, method, args) -> {
                    String str = Thread.currentThread().getStackTrace()[2].getClassName();
                    str = str.substring(str.lastIndexOf(".") + 1);
                    str = MessageFormat.format("begin: 经纪公司 {0} 安排赛程...", str);
                    System.out.println(str);

                    Object invoke = method.invoke(driver, args);

                    System.out.println("赛程数据统计等等");

                    return invoke;
                });

        String drive = instance.drive("EQ Silver Arrow 01");

        System.out.println("\n比赛感受：" + drive);
    }

    /**
     * 无参构造方法创建对象
     */
    private static <T> T newInstance(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return (T) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 有参构造方法创建对象
     */
    private static <T> T newInstance(String className, Class[] classes, Object[] args) {
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(classes);
            return (T) constructor.newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
