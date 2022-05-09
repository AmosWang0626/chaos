package com.amos.design.behavior.state.mario_demo.design;

import com.amos.design.behavior.state.mario_demo.design.entity.SmallMario;
import lombok.Getter;

/**
 * 状态机模式
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
@Getter
public class DesignStateMachine {

    private int score;

    private IMario currentState;

    public DesignStateMachine() {
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushroom() {
        currentState.obtainMushroom(this);
    }

    public void obtainCape() {
        currentState.obtainCape(this);
    }

    public void obtainFire() {
        currentState.obtainFire(this);
    }

    public void meetMonster() {
        currentState.meetMonster(this);
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void reduceScore(int score) {
        this.score -= score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
