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
        BaseSweet baseSweet = new CakeAaaSweet();
        baseSweet = new DaaDecorator(baseSweet);
        baseSweet = new DbbDecorator(baseSweet);
        baseSweet = new DccDecorator(baseSweet);
        System.out.println(baseSweet.wear());

        System.out.println("==========华丽丽的分隔符============");

        // 第二种搭配
        baseSweet = new CakeAbbSweet();
        baseSweet = new DbbDecorator(baseSweet);
        baseSweet = new DccDecorator(baseSweet);
        System.out.println(baseSweet.wear());
    }
}
