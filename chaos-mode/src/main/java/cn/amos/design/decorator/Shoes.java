package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Shoes extends Decorator {

    public Shoes(BaseDecorator baseDecorator) {
        super(baseDecorator);
    }

    @Override
    void show() {
        super.show();
        System.out.println("穿鞋 ");
    }
}
