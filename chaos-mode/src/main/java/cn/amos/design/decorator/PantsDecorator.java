package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class PantsDecorator extends Decorator {

    public PantsDecorator(BaseDecorator baseDecorator) {
        super(baseDecorator);
    }

    @Override
    void show() {
        super.show();
        System.out.println("穿裤子 ");
    }
}
