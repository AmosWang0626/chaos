package cn.amos.mode.design.decorator2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public abstract class BaseCake {

    String desc = "一个不能吃的抽象饼";

    /**
     * 抽象方法
     *
     * @return 价格
     */
    abstract double price();

    public String getDesc() {
        return desc;
    }
}
