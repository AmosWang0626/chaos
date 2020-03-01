package com.amos.design.behavior.chain;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 责任链
 *
 * @author Daoyuan
 * @date 2019/3/20
 */
public class Main {

    public static void main(String[] args) {
        BaseDeveloper junior = new Developers.DeveloperOne();
        BaseDeveloper middle = new Developers.DeveloperTwo();
        BaseDeveloper advanced = new Developers.DeveloperThree();

        junior.plusDeveloper(middle);
        middle.plusDeveloper(advanced);

        junior.develop(BaseDeveloper.HardLevel.ONE, "研发 一般需求");
        junior.develop(BaseDeveloper.HardLevel.TWO, "研发 中级需求");
        junior.develop(BaseDeveloper.HardLevel.THREE, "研发 高级需求");
    }

}
