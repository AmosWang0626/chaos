package com.amos.design.creation.singleton;

/**
 * DESCRIPTION: 单例模式——恶汉
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/22/2020
 */
public class HungerSingleton {

    private static HungerSingleton hungerSingleton = new HungerSingleton();

    private HungerSingleton() {
        System.out.println(this.getClass().getSimpleName() + " init");
    }

    public static HungerSingleton getInstance() {
        return hungerSingleton;
    }

}
