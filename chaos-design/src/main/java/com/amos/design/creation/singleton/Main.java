package com.amos.design.creation.singleton;

import java.util.concurrent.TimeUnit;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 单例
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> EnumSingleton.getInstance().doSomething()).start();
            new Thread(() -> HolderSingleton.getInstance().doSomething()).start();
            new Thread(() -> HungerSingleton.getInstance().doSomething()).start();
            new Thread(() -> LazySingleton.getInstance().doSomething()).start();
        }
    }

}
