package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
class BaseDecorator extends BaseWear {

    private String name;

    BaseWear baseWear;

    BaseDecorator(BaseWear baseWear) {
        this.baseWear = baseWear;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 着装抽象方法
     *
     * @return 当前着装
     */
    @Override
    String wear() {
        if (baseWear != null) {
            return baseWear.wear();
        }
        return name + " 开始装扮: ";
    }
}
