package com.amos.design.creation.builder;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 建造者
 * 
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        new Cooker(new Cake01("王老师")).cookCake();
        System.out.println();
        new Cooker(new Cake02("宁老师")).cookCake();
    }

}
