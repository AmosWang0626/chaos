package com.amos.design.structure.decorator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author dell
 * @date 2019/3/27
 */
public class Cakes {

    public static class AaaCake extends BaseCake {

        @Override
        String wear() {
            return "【奶油蛋糕】" + unitPrice();
        }

        @Override
        double price() {
            return unitPrice();
        }

        @Override
        double unitPrice() {
            return 66;
        }
    }

    public static class BbbCake extends BaseCake {

        @Override
        String wear() {
            return "【水果蛋糕】" + unitPrice();
        }

        @Override
        double price() {
            return unitPrice();
        }

        @Override
        double unitPrice() {
            return 66;
        }
    }

}
