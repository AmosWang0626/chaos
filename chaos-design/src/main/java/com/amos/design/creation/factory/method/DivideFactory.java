package com.amos.design.creation.factory.method;

import java.math.BigDecimal;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/19
 */
public class DivideFactory implements IFactory {

    @Override
    public BaseOperation getInstance() {
        return new DivideOperation();
    }

    public static class DivideOperation extends BaseOperation {
        @Override
        public BigDecimal getResult() {
            return getNum1().divide(getNum2(), BigDecimal.ROUND_DOWN);
        }
    }

}
