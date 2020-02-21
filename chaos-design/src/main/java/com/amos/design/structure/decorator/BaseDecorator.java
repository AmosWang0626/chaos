package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/27
 */
public abstract class BaseDecorator extends BaseCake {

    private BaseCake baseCake;

    BaseDecorator(BaseCake baseCake) {
        this.baseCake = baseCake;
    }

    public BaseCake getBaseCake() {
        return baseCake;
    }
}
