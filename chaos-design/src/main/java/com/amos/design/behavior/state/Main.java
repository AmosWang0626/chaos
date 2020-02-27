package com.amos.design.behavior.state;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 状态
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        Work work = new Work();
        work.atWork();
        for (int i = 0; i < 6; i++) {
            work.setHour(work.getHour() + 3);
            work.atWork();
        }
    }

}
