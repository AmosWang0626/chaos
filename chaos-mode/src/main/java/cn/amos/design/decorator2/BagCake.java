package cn.amos.design.decorator2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class BagCake extends BaseCake {

    private BaseCake baseCake;

    public BagCake(BaseCake baseCake) {
        this.baseCake = baseCake;
    }

    @Override
    void food() {
        System.out.println("开始制作布袋饼: ");
        if (baseCake != null) {
            baseCake.food();
        }
    }
}
