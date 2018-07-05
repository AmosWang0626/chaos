package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
class BaseDecorator extends BaseWear {

    BaseWear baseWear;

    BaseDecorator(BaseWear baseWear) {
        this.baseWear = baseWear;
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
        return "开始装扮: ";
    }
}
