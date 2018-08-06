package cn.amos.mode.design.factory_method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 工厂方法模式
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
public class Main {

    public static void main(String[] args) {
        IProduct instance = new FactoryA().getInstance();
        System.out.println("This product name is " + instance.name());
    }
}
