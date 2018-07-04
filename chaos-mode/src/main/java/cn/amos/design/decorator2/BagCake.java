package cn.amos.design.decorator2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class BagCake extends BaseCake {

    public BagCake() {
        desc = "布袋饼";
    }

    @Override
    double price() {
        return 5;
    }
}
