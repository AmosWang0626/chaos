package cn.amos.mode.base.abstracts.graph;

/**
 * PROJECT: chaos
 * DESCRIPTION: 方形
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class GraphRectangle extends BaseGraph {

    private double length;
    private double height;

    public GraphRectangle(double length, double height) {
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
