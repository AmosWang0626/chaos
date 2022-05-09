package com.amos.design.behavior.state.mario_demo.sample;

/**
 * 基础状态测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public class MarioSimpleAppMain {

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        stateMachine.printMarioInfo();

        stateMachine.obtainMushroom().printMarioInfo();
        stateMachine.obtainMushroom().printMarioInfo();
        stateMachine.meetMonster().printMarioInfo();
        stateMachine.meetMonster().printMarioInfo();
    }

}
