package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos
 * DESCRIPTION: Decorator
 *
 * @author DaoyuanWang
 * @date 2018/7/3
 */
public class Decorators {

    public static class AaaDecorator extends BaseDecorator {

        public AaaDecorator(BaseCake baseWear) {
            super(baseWear);
        }

        @Override
        String wear() {
            return getBaseCake().wear() + " 加蜡烛" + unitPrice();
        }

        @Override
        double price() {
            return getBaseCake().price() + unitPrice();
        }

        @Override
        double unitPrice() {
            return 5;
        }
    }

    public static class BbbDecorator extends BaseDecorator {

        public BbbDecorator(BaseCake baseWear) {
            super(baseWear);
        }

        @Override
        String wear() {
            return getBaseCake().wear() + " 加水果" + unitPrice();
        }

        @Override
        double price() {
            return getBaseCake().price() + unitPrice();
        }

        @Override
        double unitPrice() {
            return 8;
        }
    }

    public static class CccDecorator extends BaseDecorator {

        CccDecorator(BaseCake baseWear) {
            super(baseWear);
        }

        @Override
        String wear() {
            return getBaseCake().wear() + " 加餐具" + unitPrice();
        }

        @Override
        double price() {
            return getBaseCake().price() + unitPrice();
        }

        @Override
        double unitPrice() {
            return 5;
        }
    }

}
