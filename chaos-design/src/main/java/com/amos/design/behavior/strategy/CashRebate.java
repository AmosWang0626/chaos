package com.amos.design.behavior.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 打折优惠
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class CashRebate extends BaseCash {

    /**
     * 折扣
     */
    private BigDecimal rebate;

    public CashRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    @Override
    BigDecimal paymentAmount(BigDecimal amount) {
        return amount.multiply(rebate).setScale(0, BigDecimal.ROUND_DOWN);
    }
}
