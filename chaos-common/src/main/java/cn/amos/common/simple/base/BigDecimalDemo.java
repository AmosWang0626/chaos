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

        // ***********************************************************
        BigDecimal preFee = BigDecimal.ZERO;
        BigDecimal loanAmt = new BigDecimal("1000");
        if (loanAmt.compareTo(new BigDecimal(1470)) == 0) {
            preFee = new BigDecimal("1.4").setScale(1, BigDecimal.ROUND_HALF_UP);
        } else if (loanAmt.compareTo(new BigDecimal(1725)) == 0) {
            preFee = new BigDecimal("1.5").setScale(1, BigDecimal.ROUND_HALF_UP);
        } else if (loanAmt.compareTo(new BigDecimal(1000)) == 0) {
            preFee = new BigDecimal("1.428").setScale(3, BigDecimal.ROUND_HALF_UP);
        }
        BigDecimal loanFee = preFee.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(loanFee);
        System.out.println(loanAmt.divide(loanFee, 2, BigDecimal.ROUND_HALF_UP));
    }


    /*
     * 1.400
     * 1050.00
     *
     * 1.500
     * 1150.00
     *
     * 1.428
     * 700.28
     */
}
