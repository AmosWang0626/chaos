package com.amos.design.creation.singleton;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 单例
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(LazySingleton::getInstance);
            new Thread(HungerSingleton::getInstance).start();
        }
    }

}
