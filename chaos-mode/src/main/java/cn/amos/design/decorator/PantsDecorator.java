package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
class PantsDecorator extends BaseDecorator {

    PantsDecorator(BaseWear baseWear) {
        super(baseWear);
    }

    @Override
    String wear() {
        return baseWear.wear() + " 穿裤子";
    }
}
