package com.amos.design.behavior.state.mario_demo.design;

import com.amos.design.behavior.state.mario_demo.MarioState;

/**
 * IMario
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public interface IMario {

    /**
     * 获取马里奥当前状态
     *
     * @return State
     */
    MarioState getState();


    /**
     * 吃蘑菇
     *
     * @param machine 状态机
     */
    void obtainMushroom(DesignStateMachine machine);

    /**
     * 获得斗篷
     *
     * @param machine 状态机
     */
    void obtainCape(DesignStateMachine machine);

    /**
     * 获得火焰
     *
     * @param machine 状态机
     */
    void obtainFire(DesignStateMachine machine);

    /**
     * 遇到怪物处理逻辑
     *
     * @param machine 状态机
     */
    void meetMonster(DesignStateMachine machine);

}
