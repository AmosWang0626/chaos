package com.amos.design.behavior.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * DESCRIPTION: 计算器
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/26/2020
 */
public class Calculator {

    private BaseExpression expression;

    public Calculator(String expStr) {
        Stack<BaseExpression> stack = new Stack<>();
        char[] chars = expStr.toCharArray();

        BaseExpression left;
        BaseExpression right;
        for (int i = 0, len = chars.length; i < len; i++) {
            switch (chars[i]) {
                case '+':
                    System.out.println("+++");
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SymbolAdd(left, right));
                    break;

                case '-':
                    System.out.println("---");
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SymbolSub(left, right));
                    break;

                default:
                    stack.push(new VarExpression(String.valueOf(chars[i])));
            }
        }
        expression = stack.pop();
    }

    public int run(HashMap<String, Integer> params) {
        return expression.interpreter(params);
    }

}
