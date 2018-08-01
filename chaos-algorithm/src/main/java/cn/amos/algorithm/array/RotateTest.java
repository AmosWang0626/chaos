package cn.amos.algorithm.array;

import java.util.Arrays;

/**
 * PROJECT: chaos
 * DESCRIPTION: 移动数组
 *
 * @author DaoYuanWang
 * @date 2018/7/31
 */
public class RotateTest {

    public static void main(String[] args) {
        int k = 6;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        // rotate2(arr, k);
        rotateAverage(arr, k);
    }

    /**
     * length % 2 == 0 & k = length / 2
     *
     * @param nums 数组
     * @param k    右移个数
     */
    private static void rotateAverage(int[] nums, int k) {

        int len = nums.length;

        int cycle1 = k < len / 2 ? k : len - k;
        int cycle2 = len / cycle1;

        for (int j = 0; j < cycle1; j++) {
            int tempValue = nums[j];
            int pos = (k + j) % nums.length;

            for (int i = 0; i < cycle2; i++) {
                nums[pos] = tempValue + nums[pos];
                tempValue = nums[pos] - tempValue;
                nums[pos] = nums[pos] - tempValue;

                pos = (pos + k) % nums.length;

                // System.out.println(Arrays.toString(nums) + "\t" + tempValue);
            }
        }

        System.out.println(Arrays.toString(nums));

    }

}
