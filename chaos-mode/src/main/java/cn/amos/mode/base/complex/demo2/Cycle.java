package cn.amos.mode.base.complex.demo2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Cycle extends BaseShape {

    private double radius;

    public Cycle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        // 调用平方Math.pow(radius, 2)也一样
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}
