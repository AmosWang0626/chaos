package com.amos.design.behavior.observer.beforejdk9;

import java.util.Observable;
import java.util.Observer;

/**
 * DESCRIPTION: 多个用户
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/21/2020
 */
public class Persons {

    public static class Person1 implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>> " + arg);
        }
    }

    public static class Person2 implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>> " + arg);
        }
    }

    public static class Person3 implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>> " + arg);
        }
    }

}
