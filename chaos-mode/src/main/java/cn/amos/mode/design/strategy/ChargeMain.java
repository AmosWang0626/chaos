package cn.amos.mode.design.strategy;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class ChargeMain {

    public static void main(String[] args) {
        BigDecimal paymentAmount = new BigDecimal(1000);

        ChargeContext chargeNormal = new ChargeContext(new ChargeNormal());
        chargeNormal.contextInterface(paymentAmount);
        ChargeContext chargeRebate = new ChargeContext(new ChargeRebate(new BigDecimal(0.8)));
        chargeRebate.contextInterface(paymentAmount);
        ChargeContext chargeReturn = new ChargeContext(new ChargeReturn(new BigDecimal(300), new BigDecimal(100)));
        chargeReturn.contextInterface(paymentAmount);

        ChargeContextFactory normalAmount = new ChargeContextFactory("normal");
        normalAmount.contextInterface(paymentAmount);
        ChargeContextFactory rebateAmount = new ChargeContextFactory("rebate");
        rebateAmount.contextInterface(paymentAmount);
        ChargeContextFactory returnAmount = new ChargeContextFactory("return");
        returnAmount.contextInterface(paymentAmount);
    }
}
