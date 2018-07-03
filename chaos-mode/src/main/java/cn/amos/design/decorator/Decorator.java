package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Decorator extends BaseDecorator {

    private String name;

    public Decorator(String name) {
        this.name = name;
        System.out.println(name + " 开始装扮：");
    }

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
