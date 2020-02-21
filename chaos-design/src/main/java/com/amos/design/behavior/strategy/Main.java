package com.amos.design.behavior.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 策略模式 (它定义了算法家族，分别封装起来)
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal paymentAmount = new BigDecimal(1000);

        // 策略模式
        CashContext chargeNormal = new CashContext(new CashNormal());
        chargeNormal.print(paymentAmount);
        CashContext chargeRebate = new CashContext(new CashRebate(new BigDecimal("0.8")));
        chargeRebate.print(paymentAmount);
        CashContext chargeReturn = new CashContext(new CashReturn(new BigDecimal(300), new BigDecimal(100)));
        chargeReturn.print(paymentAmount);

        System.out.println();

        // 策略工厂模式
        CashContextFactory normalAmount = new CashContextFactory("normal");
        normalAmount.print(paymentAmount);
        CashContextFactory rebateAmount = new CashContextFactory("rebate");
        rebateAmount.print(paymentAmount);
        CashContextFactory returnAmount = new CashContextFactory("return");
        returnAmount.print(paymentAmount);
    }

}
