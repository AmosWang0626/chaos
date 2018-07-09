package cn.amos.mode.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Main {

    public static void main(String[] args) {

        BaseDecorator baseDecorator = new BaseDecorator(null);
        baseDecorator.setName("啦啦啦");

        // 第一种着装
        ClothesDecorator clothesDecorator = new ClothesDecorator(baseDecorator);
        PantsDecorator pantsDecorator = new PantsDecorator(clothesDecorator);
        ShoesDecorator shoesDecorator = new ShoesDecorator(pantsDecorator);
        System.out.println(shoesDecorator.wear());

        System.out.println("==========华丽丽的分隔符============");

        // 第二种着装
        PantsDecorator pantsDecorator1 = new PantsDecorator(baseDecorator);
        ShoesDecorator shoesDecorator1 = new ShoesDecorator(pantsDecorator1);
        ClothesDecorator clothesDecorator1 = new ClothesDecorator(shoesDecorator1);
        System.out.println(clothesDecorator1.wear());
    }
}
