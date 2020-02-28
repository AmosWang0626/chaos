package com.amos.design.behavior.mediator;

/**
 * DESCRIPTION: 联合国安理会
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public class UnSecurity extends BaseUn {

    @Override
    public void declare(String message, BaseCountry country) {
        if (country == getCountry1()) {
            getCountry2().receive(message);
            return;
        }
        getCountry1().receive(message);
    }
}
