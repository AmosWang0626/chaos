package com.amos.design.behavior.state.mario_demo.table;

/**
 * 马里奥遇到的事件
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public enum MarioEvent {

    /**
     * 蘑菇
     */
    GET_MUSHROOM(0),
    /**
     * 斗篷
     */
    GET_CAPE(1),
    /**
     * 火焰
     */
    GET_FIRE(2),
    /**
     * 遇到怪物
     */
    MEET_MONSTER(3),
    ;


    private final int code;

    MarioEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
