package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/27
 */
public abstract class BaseDecorator extends BaseSweet {

    private BaseSweet baseSweet;

    BaseDecorator(BaseSweet baseSweet) {
        this.baseSweet = baseSweet;
    }

    public BaseSweet getBaseSweet() {
        return baseSweet;
    }
}
