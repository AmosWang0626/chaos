package cn.amos.mode.design.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class ChargeContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChargeContext.class);

    private AbstractCharge abstractCharge;

    public ChargeContext(AbstractCharge abstractCharge) {
        this.abstractCharge = abstractCharge;
    }

    public void contextInterface(BigDecimal amount) {
        LOGGER.info(abstractCharge.getClass().getSimpleName() + " 应支付金额: " + abstractCharge.paymentAmount(amount));
    }
}
