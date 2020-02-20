package com.amos.design.creation.builder;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/7
 */
public class Cake01 extends BaseCake {

    public Cake01(String name) {
        super(name);
    }

    @Override
    public void caskModel() {
        printInfo();
    }

    @Override
    public void addFlavoring() {
        printInfo();
    }

    @Override
    public void addOil() {
        printInfo();
    }

    @Override
    public void caskToOil() {
        printInfo();
    }

    @Override
    public void finish() {
        printInfo();
    }

    private void printInfo() {
        String className = this.getClass().getSimpleName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(String.format("【%s】 正在制作 %s, 当前步骤【%s】", name, className, methodName));
    }
}
