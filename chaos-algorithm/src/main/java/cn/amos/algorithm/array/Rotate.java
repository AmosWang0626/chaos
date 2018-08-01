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
        int k = 7;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        rotate2(arr, k);
    }

    /**
     * 方式 1
     */
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

    /**
     * 方式 2
     * <p>
     * nums 为奇数时正常, 否则异常
     */
    private static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return;
        }

        // 同为偶数时异常
        if ((nums.length + k) % 2 != 0) {

            // 元素的值 ---> 默认为第0个元素的值
            int tempValue = nums[0];
            // 要移动到的位置 ---> 默认为第0个元素要移动到的位置
            int pos = k % nums.length;

            for (int i = 0; i < nums.length; i++) {
                nums[pos] = tempValue + nums[pos];
                tempValue = nums[pos] - tempValue;
                nums[pos] = nums[pos] - tempValue;

                pos = (pos + k) % nums.length;
            }

            System.out.println(Arrays.toString(nums));

        }
    }

    private static void rotate3(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return;
        }

        k = k % nums.length;

        // 以下数量数字可直接移到后边
        int endCount = nums.length - k;
        int startCount = nums.length - endCount;

        int[] end = new int[endCount];

        System.arraycopy(nums, 0, end, 0, endCount);

        int[] start = new int[startCount];

        System.arraycopy(nums, endCount, start, 0, nums.length - endCount);

        for (int i = 0; i < nums.length; i++) {
            if (i < startCount) {
                nums[i] = start[i];
            } else {
                nums[i] = end[i - startCount];
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}
