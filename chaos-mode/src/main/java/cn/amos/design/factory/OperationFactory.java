package cn.amos.design.factory;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class OperationFactory {

    public static Operation createOperate(String operate) {
        Operation operation = null;

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
}
