package com.amos.design.creation.singleton;

/**
 * DESCRIPTION: 单例模式——懒汉
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/22/2020
 */
public class LazySingleton implements BaseSomeThing {

    private static LazySingleton lazySingleton;

    private LazySingleton() {
        System.out.println(this.getClass().getSimpleName() + " init");
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    @Override
    public void doSomething() {
        System.out.println(this);
    }

}
