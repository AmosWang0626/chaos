package com.amos.design.creation.factory.method;

import java.math.BigDecimal;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/19
 */
public class SubtractOperation extends BaseOperation {

    @Override
    public BigDecimal getResult() {
        return getNum1().subtract(getNum2());
    }

}
