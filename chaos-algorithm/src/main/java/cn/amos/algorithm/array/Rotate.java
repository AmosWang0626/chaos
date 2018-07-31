package cn.amos.algorithm.array;

import java.util.Arrays;

/**
 * PROJECT: chaos
 * DESCRIPTION: 移动数组
 *
 * @author DaoYuanWang
 * @date 2018/7/31
 */
public class Rotate {

    public static void main(String[] args) {
        int k = 4;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        rotate1(arr, k);
    }

    private static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return;
        }

        int len = nums.length;

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            int temp = (i + k) % len;

            arr[temp] = nums[i];
        }

        System.out.println(Arrays.toString(nums));

        nums = arr;

        System.out.println(Arrays.toString(nums));
    }

}
