package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
class DaaDecorator extends BaseDecorator {

    DaaDecorator(BaseSweet baseWear) {
        super(baseWear);
    }

    @Override
    String wear() {
        return getBaseSweet().wear() + " 加蜡烛";
    }

    @Override
    double price() {
        return 5;
    }
}
