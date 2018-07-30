package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
class ShoesDecorator extends BaseDecorator {

    ShoesDecorator(BaseWear baseWear) {
        super(baseWear);
    }

    @Override
    String wear() {
        return baseWear.wear() + " 穿鞋";
    }
}