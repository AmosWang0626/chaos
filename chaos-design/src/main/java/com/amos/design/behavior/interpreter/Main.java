package com.amos.design.behavior.interpreter;

import java.util.HashMap;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 解释器
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        String expression = "a + b - c + d";
        Calculator calculator = new Calculator(expression.replace(" ", ""));
        HashMap<String, Integer> params = new HashMap<>(4);
        params.put("a", 100);
        params.put("b", 100);
        params.put("c", 100);
        params.put("d", 88);
        int run = calculator.run(params);
        System.out.println(String.format(
                "表达式: [ %s ], 参数: %s, 执行结果: %s", expression, params, run)
        );
    }

}
