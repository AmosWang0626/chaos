package com.amos.design.behavior.state.mario_demo.table;

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
     * 二维数组 (纵轴: 当前马里奥状态; 纵轴: 当前事件)
     * ________|   蘑菇0     斗篷1     火焰2     怪兽3
     * 小马里奥0    SUPER+      CAPE+   FIRE+    SMALL0
     * 超级马里奥1   SUPER0     CAPE+   FIRE+    SMALL-
     * 斗篷马里奥2   CAPE0      CAPE0   CAPE0    SMALL-
     * 火焰马里奥3   FIRE0      FIRE0   FIRE0    SMALL-
     */
    private static final MarioState[][] TRANS_TABLE = {
            {MarioState.SUPER, MarioState.CAPE, MarioState.FIRE, MarioState.SMALL},
            {MarioState.SUPER, MarioState.CAPE, MarioState.FIRE, MarioState.SMALL},
            {MarioState.CAPE, MarioState.CAPE, MarioState.CAPE, MarioState.SMALL},
            {MarioState.FIRE, MarioState.FIRE, MarioState.FIRE, MarioState.SMALL}
    };

    private static final int[][] SCORE_TABLE = {
            {MarioState.SUPER.getScore(), MarioState.CAPE.getScore(), MarioState.FIRE.getScore(), 0},
            {0, MarioState.CAPE.getScore(), MarioState.FIRE.getScore(), -MarioState.SMALL.getScore()},
            {0, 0, 0, -MarioState.SMALL.getScore()},
            {0, 0, 0, -MarioState.SMALL.getScore()}
    };

    /**
     * 吃蘑菇
     */
    public StateMachine obtainMushroom() {
        execute(MarioEvent.GET_MUSHROOM);

        return this;
    }

    /**
     * 获得斗篷
     */
    public StateMachine obtainCape() {
        execute(MarioEvent.GET_CAPE);

        return this;
    }

    /**
     * 获得火焰
     */
    public StateMachine obtainFire() {
        execute(MarioEvent.GET_FIRE);

        return this;
    }

    /**
     * 遇到怪物处理逻辑
     */
    public StateMachine meetMonster() {
        execute(MarioEvent.MEET_MONSTER);

        return this;
    }

    private void execute(MarioEvent event) {
        this.currentState = TRANS_TABLE[this.currentState.getState()][event.getCode()];
        this.score += SCORE_TABLE[this.currentState.getState()][event.getCode()];
    }

}
