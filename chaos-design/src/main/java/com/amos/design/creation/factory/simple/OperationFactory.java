package com.amos.design.creation.factory.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class OperationFactory {

    public static AbstractOperation createOperate(String operate) {
        AbstractOperation operation = null;

        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;

            case "-":
                operation = new OperationSubtract();
                break;

            case "*":
                operation = new OperationMultiply();
                break;

            case "/":
                operation = new OperationDivide();
                break;

            default:
                break;
        }

        return operation;
    }

    public static class OperationAdd extends AbstractOperation {

        @Override
        public double getResult() {
            return getNum1() + getNum2();
        }
    }

    public static class OperationSubtract extends AbstractOperation {

        @Override
        public double getResult() {
            return getNum1() - getNum2();
        }
    }

    public static class OperationMultiply extends AbstractOperation {

        @Override
        public double getResult() {
            return getNum1() * getNum2();
        }
    }

    public static class OperationDivide extends AbstractOperation {

        @Override
        public double getResult() {
            return getNum1() / getNum2();
        }
    }

}
