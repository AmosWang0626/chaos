package com.amos.design.behavior.mediator;

import lombok.Getter;

/**
 * DESCRIPTION: 国家抽象类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
@Getter
public abstract class BaseCountry {

    private BaseUn baseUn;

    public BaseCountry(BaseUn baseUn) {
        this.baseUn = baseUn;
    }

    /**
     * 国家发布声明
     *
     * @param message 声明内容
     */
    public abstract void dealer(String message);

    /**
     * 国家接收声明
     *
     * @param message 声明内容
     */
    public abstract void receive(String message);
}
