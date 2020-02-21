package com.amos.design.behavior.strategy;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 策略工厂方法
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class CashContextFactory {

    private BaseCash discount;

    public CashContextFactory(String country) {
        if (StringUtils.isBlank(country)) {
            System.out.println("国家不能为null");
            ;
        }

        switch (country) {
            case "normal":
                discount = new CashNormal();
                break;

            case "rebate":
                discount = new CashRebate(new BigDecimal("0.8"));
                break;

            case "return":
                discount = new CashReturn(new BigDecimal("300"), new BigDecimal("100"));
                break;

            default:
                break;
        }
    }

    public void print(BigDecimal amount) {
        System.out.println("初始金额: " + amount + "\t" + discount.getClass().getSimpleName() + " 应支付金额: " + discount.paymentAmount(amount));
    }

}
