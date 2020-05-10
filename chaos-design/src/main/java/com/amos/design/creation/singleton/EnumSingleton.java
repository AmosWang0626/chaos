package com.amos.design.creation.singleton;

/**
 * DESCRIPTION: 单例模式——枚举
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public enum EnumSingleton implements BaseSomeThing {

    /***/
    INSTANCE;

    EnumSingleton() {
        System.out.println(this.getClass().getSimpleName() + " init");
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    @Override
    public void doSomething() {
        System.out.println(this);
    }
}
