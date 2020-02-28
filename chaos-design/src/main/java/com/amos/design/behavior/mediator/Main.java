package com.amos.design.behavior.mediator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 中介者
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        BaseUn unSecurity = new UnSecurity();

        // 美国/伊朗 都去找联合国
        BaseCountry usa = new Countries.Usa(unSecurity);
        BaseCountry iraq = new Countries.Iraq(unSecurity);

        // 联合国派安理会处理
        System.out.println("联合国安理会约谈 伊朗 和 美国 的外交部部长");
        unSecurity.setCountries(usa, iraq);

        usa.dealer("不准研发核武器, 否则发动战争");
        iraq.dealer("我们没有核武器, 也不怕侵略");
    }

}
