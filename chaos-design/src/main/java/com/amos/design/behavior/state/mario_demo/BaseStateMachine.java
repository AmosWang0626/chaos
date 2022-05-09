package com.amos.design.behavior.state.mario_demo;

/**
 * 马里奥状态机
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public abstract class BaseStateMachine {

    protected int score;

    protected MarioState currentState;

    public BaseStateMachine() {
        MarioState state = MarioState.SMALL;
        this.score = state.getScore();
        this.currentState = state;
    }

    /**
     * 吃蘑菇
     *
     * @return this
     */
    protected abstract BaseStateMachine obtainMushroom();

    /**
     * 获得斗篷
     *
     * @return this
     */
    protected abstract BaseStateMachine obtainCape();

    /**
     * 获得火焰
     *
     * @return this
     */
    protected abstract BaseStateMachine obtainFire();

    /**
     * 遇到怪物处理逻辑
     *
     * @return this
     */
    protected abstract BaseStateMachine meetMonster();


    public int getScore() {
        return score;
    }

    public MarioState getCurrentState() {
        return currentState;
    }

    /**
     * 打印马里奥当前信息
     */
    public void printMarioInfo() {
        System.out.printf("[马里奥] 当前积分: %d, 马里奥当前状态: %s\n", getScore(), getCurrentState());
    }
}
