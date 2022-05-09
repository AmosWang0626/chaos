package com.amos.design.behavior.state.mario_demo.design.entity;

import com.amos.design.behavior.state.mario_demo.MarioState;
import com.amos.design.behavior.state.mario_demo.design.DesignStateMachine;
import com.amos.design.behavior.state.mario_demo.design.IMario;

/**
 * 超级马里奥
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2022/5/8
 */
public class SuperMario implements IMario {

    private static final SuperMario INSTANCE = new SuperMario();

    public static IMario getInstance() {
        return INSTANCE;
    }

    @Override
    public MarioState getState() {
        return MarioState.SUPER;
    }

    @Override
    public void obtainMushroom(DesignStateMachine machine) {
    }

    @Override
    public void obtainCape(DesignStateMachine machine) {
        machine.setCurrentState(CapeMario.getInstance());
        machine.addScore(MarioState.CAPE.getScore());
    }

    @Override
    public void obtainFire(DesignStateMachine machine) {
        machine.setCurrentState(FireMario.getInstance());
        machine.addScore(MarioState.FIRE.getScore());
    }

    @Override
    public void meetMonster(DesignStateMachine machine) {
        machine.setCurrentState(SmallMario.getInstance());
        machine.reduceScore(getState().getScore());
    }
}
