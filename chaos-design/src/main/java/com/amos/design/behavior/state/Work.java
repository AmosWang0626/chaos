package com.amos.design.behavior.state;

import lombok.Data;

/**
 * DESCRIPTION: Work
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/27/2020
 */
@Data
public class Work {

    /**
     * 状态抽象
     */
    private BaseState state;
    /**
     * 小时 [9:00 ~ 23:00]
     */
    private int hour;

    public Work() {
        this.state = new BaseState.MorningState();
        this.hour = 9;
    }

    public void atWork() {
        state.work(this);
    }

}
