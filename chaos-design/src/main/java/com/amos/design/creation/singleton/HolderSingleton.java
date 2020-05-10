package com.amos.design.creation.singleton;

/**
 * DESCRIPTION: 单例模式——饿汉 + 内部类懒汉方式
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public class HolderSingleton implements BaseSomeThing {

    public HolderSingleton() {
        System.out.println(this.getClass().getSimpleName() + " init");
    }

    private static class Holder {
        private static HolderSingleton instance = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.instance;
    }

    @Override
    public void doSomething() {
        System.out.println(this);
    }
}
