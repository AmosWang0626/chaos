package cn.amos.mode.design.creation.builder;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/7
 */
public class Cooker {

    private BaseCakeBuild baseCakeBuild;

    public Cooker(BaseCakeBuild baseCakeBuild) {
        this.baseCakeBuild = baseCakeBuild;
    }

    public void cookCake() {
        baseCakeBuild.caskModel();
        baseCakeBuild.addFlavoring();
        baseCakeBuild.addOil();
        baseCakeBuild.caskToOil();
        baseCakeBuild.pan();
    }


}
