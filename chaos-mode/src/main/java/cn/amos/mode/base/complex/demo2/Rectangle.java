package cn.amos.mode.base.complex.demo2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Rectangle extends BaseShape {

    private double length;
    private double height;

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    double area() {
        return length * height;
    }

    @Override
    double perimeter() {
        return 2 * (length + height);
    }
}
