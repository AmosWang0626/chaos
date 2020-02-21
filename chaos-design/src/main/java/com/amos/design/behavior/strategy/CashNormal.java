package com.amos.design.behavior.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 原价
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class CashNormal extends BaseCash {

    @Override
    BigDecimal paymentAmount(BigDecimal amount) {
        return amount;
    }
}
