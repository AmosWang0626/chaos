package cn.amos.design.strategy;

import org.apache.commons.lang3.StringUtils;
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
public class ChargeContextFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChargeContextFactory.class);

    private AbstractCharge abstractCharge;

    public ChargeContextFactory(String country) {
        if (StringUtils.isBlank(country)) {
            LOGGER.info("国家不能为null");
        }

        switch (country) {
            case "normal":
                abstractCharge = new ChargeNormal();
                break;

            case "rebate":
                abstractCharge = new ChargeRebate(new BigDecimal("0.8"));
                break;

            case "return":
                abstractCharge = new ChargeReturn(new BigDecimal("300"), new BigDecimal("100"));
                break;

            default:
                break;
        }
    }

    public void contextInterface(BigDecimal amount) {
        LOGGER.info(abstractCharge.getClass().getSimpleName() + " 应支付金额: " + abstractCharge.paymentAmount(amount));
    }
}
