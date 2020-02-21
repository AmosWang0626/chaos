package com.amos.design.behavior.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 满减优惠
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class CashReturn extends BaseCash {

    /**
     * 起始金额
     */
    private BigDecimal startAmount;
    /**
     * 返利金额
     */
    private BigDecimal backAmount;

    public CashReturn(BigDecimal startAmount, BigDecimal backAmount) {
        this.startAmount = startAmount;
        this.backAmount = backAmount;
    }

    @Override
    BigDecimal paymentAmount(BigDecimal amount) {
        return amount.subtract(amount.divide(startAmount, BigDecimal.ROUND_DOWN).multiply(backAmount));
    }
}
