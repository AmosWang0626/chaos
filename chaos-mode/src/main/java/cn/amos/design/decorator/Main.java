package cn.amos.design.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Main {

    public static void main(String[] args) {
        ClothesDecorator clothesDecorator = new ClothesDecorator(null);
        PantsDecorator pantsDecorator = new PantsDecorator(clothesDecorator);
        ShoesDecorator shoesDecorator = new ShoesDecorator(pantsDecorator);
        shoesDecorator.show();

        System.out.println("==========华丽丽的分隔符============");

        PantsDecorator pantsDecorator1 = new PantsDecorator(null);
        ShoesDecorator shoesDecorator1 = new ShoesDecorator(pantsDecorator1);
        ClothesDecorator clothesDecorator1 = new ClothesDecorator(shoesDecorator1);
        clothesDecorator1.show();
    }
}
