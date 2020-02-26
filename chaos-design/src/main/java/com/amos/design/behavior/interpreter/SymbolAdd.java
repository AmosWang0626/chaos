package com.amos.design.behavior.interpreter;

import java.util.HashMap;

/**
 * DESCRIPTION: +
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
public class SymbolAdd extends SymbolExpression {

    public SymbolAdd(BaseExpression left, BaseExpression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> params) {
        return super.left.interpreter(params) + super.right.interpreter(params);
    }

}
