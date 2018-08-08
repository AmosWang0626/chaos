package cn.amos.common.simple.base;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote Big *** Demo
 * @date 2018/2/1
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("12.00");
        BigDecimal bigDecimal2 = new BigDecimal("12");
        System.out.println("BigDecimal " + bigDecimal1 + " 和 " + bigDecimal2 + " " + "比较 compareTo: " + (bigDecimal1.compareTo(bigDecimal2) == 0));
        System.out.println("BigDecimal " + bigDecimal1 + " 和 " + bigDecimal2 + " " + "比较 equals: " + (bigDecimal1.equals(bigDecimal2)));
    }
}
