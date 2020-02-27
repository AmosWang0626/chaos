package com.amos.design.behavior.template;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 模板方法
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        BaseClass clz = new BaseClass.ConcreteClass1();
        clz.doFunc();

        System.out.println();

        clz = new BaseClass.ConcreteClass2();
        clz.doFunc();
    }

}
