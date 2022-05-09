package com.amos.design.behavior.state.mario_demo.design.entity;

import com.amos.design.behavior.state.mario_demo.MarioState;
import com.amos.design.behavior.state.mario_demo.design.DesignStateMachine;
import com.amos.design.behavior.state.mario_demo.design.IMario;

/**
 * 火焰马里奥
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public class FireMario implements IMario {

    private static final FireMario INSTANCE = new FireMario();

    public static IMario getInstance() {
        return INSTANCE;
    }

    @Override
    public MarioState getState() {
        return MarioState.FIRE;
    }

    @Override
    public void obtainMushroom(DesignStateMachine machine) {
    }

    @Override
    public void obtainCape(DesignStateMachine machine) {
    }

    @Override
    public void obtainFire(DesignStateMachine machine) {
    }

    @Override
    public void meetMonster(DesignStateMachine machine) {
        machine.setCurrentState(SmallMario.getInstance());
        machine.reduceScore(getState().getScore());
    }
}
