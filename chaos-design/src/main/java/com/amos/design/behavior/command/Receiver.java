package com.amos.design.behavior.command;

/**
 * DESCRIPTION: 顾客
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public class Receiver {

    private String name;

    public Receiver(String name) {
        this.name = name;
    }


    public void finish(String skewer) {
        System.out.printf("%s, 您的【%s】烤好了, 过来取吧\n", name, skewer);
    }

}
