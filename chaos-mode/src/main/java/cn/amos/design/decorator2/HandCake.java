package cn.amos.design.decorator2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class HandCake extends BaseCake {

    public HandCake() {
        desc = "手抓饼";
    }

    @Override
    double price() {
        return 4;
    }
}
