package cn.amos.design.factory;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class Operation {

    protected double num1;
    protected double num2;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    /**
     * 运算工厂模式
     *
     * @return 结果
     */
    public double getResult() {
        return 0;
    }
}
