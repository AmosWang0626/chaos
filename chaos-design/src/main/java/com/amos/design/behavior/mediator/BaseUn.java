package com.amos.design.behavior.mediator;

import lombok.Getter;

/**
 * DESCRIPTION: 联合国机构
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
@Getter
public abstract class BaseUn {

    private BaseCountry country1;
    private BaseCountry country2;

    public void setCountries(BaseCountry country1, BaseCountry country2) {
        this.country1 = country1;
        this.country2 = country2;
    }

    /**
     * 声明
     *
     * @param message 消息
     * @param country 国家
     */
    public abstract void declare(String message, BaseCountry country);

}
