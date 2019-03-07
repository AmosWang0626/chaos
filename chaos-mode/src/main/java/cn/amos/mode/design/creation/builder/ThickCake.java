package cn.amos.mode.design.creation.builder;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/7
 */
public class ThickCake extends BaseCakeBuild {

    private int index;

    ThickCake(String name) {
        super(name);
    }

    @Override
    public void caskModel() {
        base();
    }

    @Override
    public void addFlavoring() {
        base();
    }

    @Override
    public void addOil() {
        base();
    }

    @Override
    public void caskToOil() {
        base();
    }

    @Override
    public void pan() {
        base();
    }

    private void base() {
        index++;
        // Arrays.toString(Thread.currentThread().getStackTrace())
        System.out.println(this.getClass().getSimpleName() + " >>> " + name + " <<< " + index + " >>> " + Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
