package com.amos.design.creation.builder;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/7
 */
public abstract class BaseCake {

    protected String name;

    public BaseCake(String name) {
        this.name = name;
    }

    /**
     * 制作面饼
     */
    public abstract void caskModel();

    /**
     * 加入调料
     */
    public abstract void addFlavoring();

    /**
     * 锅里加油
     */
    public abstract void addOil();

    /**
     * 油热放饼
     */
    public abstract void caskToOil();

    /**
     * 烙好出锅
     */
    public abstract void finish();

}
