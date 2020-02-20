package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
class DbbDecorator extends BaseDecorator {

    DbbDecorator(BaseSweet baseWear) {
        super(baseWear);
    }

    @Override
    String wear() {
        return getBaseSweet().wear() + " 加水果";
    }

    @Override
    double price() {
        return 8;
    }
}
