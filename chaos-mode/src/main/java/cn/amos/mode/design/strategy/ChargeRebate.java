package cn.amos.mode.design.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class ChargeRebate extends AbstractCharge {

    private BigDecimal rebate;

    public ChargeRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    @Override
    BigDecimal paymentAmount(BigDecimal amount) {
        return amount.multiply(rebate).setScale(0, BigDecimal.ROUND_DOWN);
    }
}
