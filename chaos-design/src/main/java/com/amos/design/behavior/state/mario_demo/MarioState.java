package com.amos.design.behavior.state.mario_demo;

/**
 * 马里奥状态枚举
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public enum MarioState {

    /**
     * 小马里奥
     */
    SMALL(0, 0),
    /**
     * 超级马里奥
     */
    SUPER(1, 100),
    /**
     * 斗篷马里奥
     */
    CAPE(2, 200),
    /**
     * 火焰马里奥
     */
    FIRE(3, 300),
    ;


    private final int state;
    private final int score;

    MarioState(int state, int score) {
        this.state = state;
        this.score = score;
    }

    public int getState() {
        return state;
    }

    public int getScore() {
        return score;
    }
}
