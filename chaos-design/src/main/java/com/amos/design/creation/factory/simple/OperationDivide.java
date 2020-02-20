package com.amos.design.creation.factory.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class OperationDivide extends AbstractOperation {

    @Override
    public double getResult() {
        return getNum1() / getNum2();
    }
}
