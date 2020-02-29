package com.amos.advanced.java.method;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/29
 */
public class OverLoad {

    private abstract static class BaseHuman {

    }

    private static class Woman extends BaseHuman {

    }

    private static class Man extends BaseHuman {

    }

    public void sayHello(BaseHuman human) {
        System.out.println("this is human!");
        /// 兼容处理
        // if (human instanceof Man) {
        //     sayHello((Man) human);
        // } else if (human instanceof Woman) {
        //     sayHello((Woman) human);
        // }
    }

    public void sayHello(Woman human) {
        System.out.println("this is woman!");
    }

    public void sayHello(Man human) {
        System.out.println("this is man!");
    }

    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();

        BaseHuman woman = new Woman();
        overLoad.sayHello(woman);
        BaseHuman man = new Man();
        overLoad.sayHello(man);

        System.out.println("*****************");

        BaseHuman human = new Woman();
        overLoad.sayHello(human);
        human = new Man();
        overLoad.sayHello(human);
    }

}
