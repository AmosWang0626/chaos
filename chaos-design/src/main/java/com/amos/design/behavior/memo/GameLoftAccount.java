package com.amos.design.behavior.memo;

/**
 * DESCRIPTION: GameLoft 账户
 * GameLoft 狂野飙车东家，游戏公司
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
public class GameLoftAccount {

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


    public GameLoftMemo saveState() {
        return new GameLoftMemo(gold, integral, cars);
    }

    public void recoveryState(GameLoftMemo memo) {
        this.gold = memo.getGold();
        this.integral = memo.getIntegral();
        this.cars = memo.getCars();
    }

    /**
     * 初始化
     */
    public void init() {
        this.gold = 10000000L;
        this.integral = 1000000L;
        this.cars = 80L;
    }

    /**
     * 买车
     *
     * @param gold     金币数
     * @param integral 代币数
     */
    public void byCar(long gold, long integral) {
        this.cars++;
        this.gold -= gold;
        this.integral -= integral;
    }

    @Override
    public String toString() {
        return "狂野飙车(GameLoft){" +
                "金币数=" + gold +
                ", 代币数=" + integral +
                ", 车辆数=" + cars +
                '}';
    }
}
