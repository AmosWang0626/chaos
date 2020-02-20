package com.amos.design.creation.factory.simple;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
@Data
@Accessors(chain = true)
public abstract class AbstractOperation {

    private double num1;
    private double num2;

    /**
     * 运算工厂模式
     *
     * @return 结果
     */
    public abstract double getResult();

}
