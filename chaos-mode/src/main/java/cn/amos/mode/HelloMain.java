package cn.amos.mode;

import java.math.BigDecimal;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/1/19
 */
public class HelloMain {

    public static void main(String[] args) {
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
