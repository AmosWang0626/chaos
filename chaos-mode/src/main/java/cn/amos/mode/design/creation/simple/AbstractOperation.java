package cn.amos.mode.design.creation.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public abstract class AbstractOperation {

    double num1;
    double num2;

    public void init(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * 运算工厂模式
     *
     * @return 结果
     */
    public abstract double getResult();

}
