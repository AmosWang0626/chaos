package cn.amos.design.decorator2;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/4
 */
public class Main {

    public static void main(String[] args) {

        BaseCake baseCake = new HandCake();
        baseCake = new MaterialEgg(baseCake);
        baseCake = new MaterialHam(baseCake);
        System.out.println(baseCake.getDesc());
        System.out.println(baseCake.price());

        System.out.println("===========华丽丽的分隔符===========");

        baseCake = new BagCake();
        baseCake = new MaterialHam(baseCake);
        baseCake = new MaterialEgg(baseCake);
        System.out.println(baseCake.getDesc());
        System.out.println(baseCake.price());
    }
}
