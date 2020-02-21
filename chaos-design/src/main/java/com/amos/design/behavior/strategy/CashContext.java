package com.amos.design.behavior.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class CashContext {

    private BaseCash discount;

    public CashContext(BaseCash discount) {
        this.discount = discount;
    }

    public void print(BigDecimal amount) {
        System.out.println("初始金额: " + amount + "\t" + discount.getClass().getSimpleName() + " 应支付金额: " + discount.paymentAmount(amount));
    }

}
