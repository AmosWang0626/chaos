package cn.amos.algorithm.array;

import java.util.Arrays;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/30
 */
public class MoveZero {

    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {

        moveZeroes(arr);
        moveZeroesFast(arr);
    }

    /**
     * 原始想法
     */
    private static void moveZeroes(int[] nums) {

        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[len] = nums[i];
                len++;
            }
        }

        for (int i = len; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }

    /**
     * 参考别人较优方法
     */
    private static void moveZeroesFast(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }

        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[len++] = nums[i];
            }
        }

        while (len < nums.length) {
            nums[len++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
