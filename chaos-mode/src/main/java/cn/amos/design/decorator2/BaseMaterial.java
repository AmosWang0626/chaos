package cn.amos.design.decorator2;

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

    /**
     * 这里不想实现它, 故抽象
     *
     * @return 描述
     */
    @Override
    public abstract String getDesc();
}
