package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/4
 */
public abstract class BaseMaterial extends BaseCake {

    BaseCake baseCake;

    public BaseMaterial(BaseCake baseCake) {
        this.baseCake = baseCake;
    }

}
