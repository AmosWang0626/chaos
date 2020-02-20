package com.amos.design.creation.builder;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/7
 */
public class Cooker {

    private BaseCake baseCake;

    public Cooker(BaseCake baseCake) {
        this.baseCake = baseCake;
    }

    public void cookCake() {
        baseCake.caskModel();
        baseCake.addFlavoring();
        baseCake.addOil();
        baseCake.caskToOil();
        baseCake.finish();
    }


}
