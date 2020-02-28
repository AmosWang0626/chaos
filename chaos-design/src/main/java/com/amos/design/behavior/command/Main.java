package com.amos.design.behavior.command;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 命令
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver("小王");

        // 烤牛肉串
        invoker.setCommand(new Commands.BeefCommand(receiver)).executeCommand();

        // 烤羊肉串
        invoker.setCommand(new Commands.LambCommand(receiver)).executeCommand();
    }

}
