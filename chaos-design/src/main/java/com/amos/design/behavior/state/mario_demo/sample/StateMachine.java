package com.amos.design.behavior.state.mario_demo.sample;

import com.amos.design.behavior.state.mario_demo.BaseStateMachine;
import com.amos.design.behavior.state.mario_demo.MarioState;

/**
 * 马里奥状态机
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public class StateMachine extends BaseStateMachine {

    /**
     * 吃蘑菇
     */
    public StateMachine obtainMushroom() {
        if (MarioState.SMALL.equals(currentState)) {
            MarioState state = MarioState.SUPER;
            this.score += state.getScore();
            this.currentState = state;
        }

        return this;
    }

    /**
     * 获得斗篷
     */
    public StateMachine obtainCape() {
        if (MarioState.SMALL.equals(currentState) || MarioState.SUPER.equals(currentState)) {
            MarioState state = MarioState.CAPE;
            this.score += state.getScore();
            this.currentState = state;
        }

        return this;
    }

    /**
     * 获得火焰
     */
    public StateMachine obtainFire() {
        if (MarioState.SMALL.equals(currentState) || MarioState.SUPER.equals(currentState)) {
            MarioState state = MarioState.FIRE;
            this.score += state.getScore();
            this.currentState = state;
        }

        return this;
    }

    /**
     * 遇到怪物处理逻辑
     */
    public StateMachine meetMonster() {
        switch (currentState) {
            case SUPER:
                execute();
                System.out.println("[遇到怪物] 超级马里奥 --> 小马里奥. " + score);
                break;

            case CAPE:
                execute();
                System.out.println("[遇到怪物] 斗篷马里奥 --> 小马里奥. " + score);
                break;

            case FIRE:
                execute();
                System.out.println("[遇到怪物] 火焰马里奥 --> 小马里奥. " + score);
                break;

            default:
                throw new RuntimeException("[遇到怪物] 马里奥挂了, 哭哭");
        }

        return this;
    }

    private void execute() {
        this.currentState = MarioState.SMALL;
        this.score -= currentState.getScore();
    }

}
