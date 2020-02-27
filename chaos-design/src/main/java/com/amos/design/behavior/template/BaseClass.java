package com.amos.design.behavior.template;

/**
 * DESCRIPTION: 抽象类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/27/2020
 */
public abstract class BaseClass {

    /**
     * function A
     */
    public abstract void funcA();

    /**
     * function A
     */
    public abstract void funcB();

    public void doFunc() {
        System.out.println(this.getClass().getSimpleName() + "\t doFunc begin...");
        funcA();
        funcB();
        System.out.println(this.getClass().getSimpleName() + "\t doFunc finish.");
    }

    public static class ConcreteClass1 extends BaseClass {

        @Override
        public void funcA() {
            System.out.println(this.getClass().getSimpleName() + "\t funcA");
        }

        @Override
        public void funcB() {
            System.out.println(this.getClass().getSimpleName() + "\t funcB");
        }
    }

    public static class ConcreteClass2 extends BaseClass {

        @Override
        public void funcA() {
            System.out.println(this.getClass().getSimpleName() + "\t funcA");
        }

        @Override
        public void funcB() {
            System.out.println(this.getClass().getSimpleName() + "\t funcB");
        }
    }

}
