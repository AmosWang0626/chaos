package cn.amos.mode.design.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class ChargeReturn extends AbstractCharge {

    private BigDecimal conditionMoney;
    private BigDecimal returnMoney;

    public ChargeReturn(BigDecimal conditionMoney, BigDecimal returnMoney) {
        this.conditionMoney = conditionMoney;
        this.returnMoney = returnMoney;
    }

    @Override
    BigDecimal paymentAmount(BigDecimal amount) {

        return amount.subtract(amount.divide(conditionMoney, BigDecimal.ROUND_DOWN).multiply(returnMoney));
    }
}
