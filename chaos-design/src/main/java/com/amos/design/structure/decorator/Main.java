package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 装饰者
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Main {

    public static void main(String[] args) {
        // 第一种搭配
        BaseCake baseSweet = new Cakes.AaaCake();
        baseSweet = new Decorators.AaaDecorator(baseSweet);
        baseSweet = new Decorators.BbbDecorator(baseSweet);
        baseSweet = new Decorators.CccDecorator(baseSweet);
        System.out.println(baseSweet.wear() + "\t总价：" + baseSweet.price());

        System.out.println("==========华丽丽的分隔符============");

        // 第二种搭配
        baseSweet = new Cakes.BbbCake();
        baseSweet = new Decorators.BbbDecorator(baseSweet);
        baseSweet = new Decorators.CccDecorator(baseSweet);
        System.out.println(baseSweet.wear() + "\t总价：" + baseSweet.price());
    }
}
