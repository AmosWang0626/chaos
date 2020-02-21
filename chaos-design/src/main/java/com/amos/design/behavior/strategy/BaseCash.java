package com.amos.design.behavior.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 优惠策略
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
abstract class BaseCash {

    /**
     * 获取优惠后的金额
     *
     * @param amount 初始金额
     * @return 优惠后的金额
     */
    abstract BigDecimal paymentAmount(BigDecimal amount);

}
