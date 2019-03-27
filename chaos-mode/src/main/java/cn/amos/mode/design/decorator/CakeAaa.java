package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class CakeAaa extends BaseCake {

    @Override
    double price() {
        return 5;
    }

    @Override
    String getDesc() {
        return "布袋饼";
    }
}
