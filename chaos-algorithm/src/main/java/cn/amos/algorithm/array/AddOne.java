package cn.amos.algorithm.array;

import java.util.Arrays;

/**
 * PROJECT: chaos
 * DESCRIPTION: 增加 1
 *
 * @author DaoYuanWang
 * @date 2018/7/30
 */
public class AddOne {

    private static final int MAX_NUM = 9;

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{0});

        if (ints != null) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
        }
    }

    public static int[] plusOne(int[] digits) {

        for (int len = digits.length - 1; len >= 0; len--) {
            if (digits[len] < MAX_NUM) {
                digits[len]++;
                return digits;
            }

            digits[len] = 0;
        }

        int[] ints = Arrays.copyOf(digits, digits.length + 1);
        ints[0] = 1;

        return ints;
    }

}