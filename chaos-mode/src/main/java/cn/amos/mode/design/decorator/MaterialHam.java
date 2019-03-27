package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/4
 */
public class MaterialHam extends BaseMaterial {

    public MaterialHam(BaseCake baseCake) {
        super(baseCake);
    }

    @Override
    double price() {
        return baseCake.price() + 2;
    }

    @Override
    public String getDesc() {
        return baseCake.getDesc() + " + 火腿";
    }
}
