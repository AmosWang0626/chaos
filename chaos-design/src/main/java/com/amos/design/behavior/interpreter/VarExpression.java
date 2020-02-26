package com.amos.design.behavior.interpreter;

import java.util.HashMap;

/**
 * DESCRIPTION: left or right
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
public class VarExpression extends BaseExpression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> params) {
        return params.get(key);
    }
}
