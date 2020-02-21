package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
abstract class BaseCake {

    /**
     * 装扮方法
     *
     * @return 已装扮
     */
    abstract String wear();

    /**
     * 价格
     *
     * @return 总价
     */
    abstract double price();

    /**
     * 单价
     *
     * @return 总价
     */
    abstract double unitPrice();

}
