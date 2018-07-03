package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class DecoratorMain {

    public static void main(String[] args) {
        Decorator decorator = new Decorator("hello");
        Clothes clothes = new Clothes(decorator);
        Pants pants = new Pants(clothes);
        Shoes shoes = new Shoes(pants);
        shoes.show();

        Decorator decorator1 = new Decorator("hello");
        Pants pants1 = new Pants(decorator1);
        Shoes shoes1 = new Shoes(pants1);
        Clothes clothes1 = new Clothes(shoes1);
        clothes1.show();
    }
}
