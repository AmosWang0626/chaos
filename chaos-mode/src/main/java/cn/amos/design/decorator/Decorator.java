package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Decorator extends BaseDecorator {

    protected BaseDecorator baseDecorator;

    public Decorator(BaseDecorator baseDecorator) {
        this.baseDecorator = baseDecorator;
    }

    @Override
    void show() {
        if (baseDecorator != null) {
            baseDecorator.show();
        }
    }
}
