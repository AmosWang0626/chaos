package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class CakeAbb extends BaseCake {

    @Override
    double price() {
        return 4;
    }

    @Override
    String getDesc() {
        return "手抓饼";
    }
}
