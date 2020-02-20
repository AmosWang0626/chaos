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
        IFactory factory =
//                new AddFactory();
//                new SubtractFactory();
                new MultiplyFactory();
//                new DivideFactory();
        BaseOperation operation = factory.getInstance();
        operation.setNum1(new BigDecimal(100));
        operation.setNum2(new BigDecimal(100));
        System.out.println(operation.getResult());
    }

}
