package cn.amos.mode.design.decorator2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class MaterialEgg extends BaseMaterial {

    public MaterialEgg(BaseCake baseCake) {
        super(baseCake);
    }

    @Override
    double price() {
        return baseCake.price() + 1.5;
    }

    @Override
    public String getDesc() {
        return baseCake.getDesc() + " + 鸡蛋";
    }
}
