package com.amos.design.behavior.memo;

import lombok.Data;

/**
 * DESCRIPTION: 游戏中的资源
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
@Data
public class GameLoftMemo {

    public GameLoftMemo(Long gold, Long integral, Long cars) {
        this.gold = gold;
        this.integral = integral;
        this.cars = cars;
    }

    /**
     * 金币数
     */
    private Long gold;
    /**
     * 代币数
     */
    private Long integral;
    /**
     * 赛车数
     */
    private Long cars;

}
