package com.amos.design.creation.factory.method;

import java.math.BigDecimal;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 工厂方法
 *
 * @author Daoyuan
 * @date 2019/3/19
 */
public class Main {

    public static void main(String[] args) {
        operation(new AddFactory());
        operation(new SubtractFactory());
        operation(new MultiplyFactory());
        operation(new DivideFactory());
    }

    private static void operation(IFactory factory) {
        BaseOperation operation = factory.getInstance();
        operation.setNum1(new BigDecimal(100));
        operation.setNum2(new BigDecimal(100));

        String className = operation.getClass().getSimpleName();
        className = className.replace("Operation", "\t\t");

        System.out.println(className + operation.getResult());
    }

}
