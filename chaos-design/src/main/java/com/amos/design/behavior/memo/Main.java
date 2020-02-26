package com.amos.design.behavior.memo;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 备忘录
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        GameLoftAccount amos = new GameLoftAccount();

        // 初始化资源 && 同步账号
        amos.init();
        System.out.println("初始化账号: " + amos);
        GameLoftMemoManager memo = new GameLoftMemoManager();
        memo.setGameLoftMemo(amos.saveState());
        System.out.println("MEMO: " + memo.getGameLoftMemo());

        // 买车 同步账号
        amos.byCar(100000L, 0);
        System.out.println("购买新车: " + amos);
        memo.setGameLoftMemo(amos.saveState());
        System.out.println("MEMO: " + memo.getGameLoftMemo());

        // 买车
        amos.byCar(0, 10000L);
        System.out.println("购买新车: " + amos);

        // 买错了(同步账号前) 撤销购买
        amos.recoveryState(memo.getGameLoftMemo());
        System.out.println("撤销购买: " + amos);

    }

}
