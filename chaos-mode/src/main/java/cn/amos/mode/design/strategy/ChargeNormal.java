package cn.amos.mode.design.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class ChargeNormal extends AbstractCharge {

    @Override
    BigDecimal paymentAmount(BigDecimal amount) {
        return amount;
    }
}
