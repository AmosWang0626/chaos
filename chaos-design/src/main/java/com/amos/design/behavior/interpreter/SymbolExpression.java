package com.amos.design.behavior.interpreter;

import java.util.HashMap;

/**
 * DESCRIPTION: left (+ - * /) right
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
public class SymbolExpression extends BaseExpression {

    protected BaseExpression left;
    protected BaseExpression right;

    public SymbolExpression(BaseExpression left, BaseExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<String, Integer> params) {
        return 0;
    }
}
