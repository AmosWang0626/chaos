package com.amos.design.behavior.interpreter;

import java.util.HashMap;

/**
 * DESCRIPTION: 抽象表达式
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
public abstract class BaseExpression {

    /**
     * 解析公式和数值，key是公式中的参数，value是具体的数值
     *
     * @param params <k, v>
     * @return result
     */
    public abstract int interpreter(HashMap<String, Integer> params);

}
