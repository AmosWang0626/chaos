package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public abstract class BaseCake {

    /**
     * 抽象方法
     *
     * @return 价格
     */
    abstract double price();

    /**
     * 获取描述
     *
     * @return 描述
     */
    abstract String getDesc();
}
