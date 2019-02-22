package cn.amos.mode.base.abstracts.graph;

/**
 * PROJECT: chaos
 * DESCRIPTION: 圆
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class GraphCycle extends BaseGraph {

    private double radius;

    public GraphCycle(double radius) {
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
