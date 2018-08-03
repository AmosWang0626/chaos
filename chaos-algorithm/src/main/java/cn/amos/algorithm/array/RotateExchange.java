package cn.amos.algorithm.array;

import java.util.Arrays;

/**
 * PROJECT: chaos
 * DESCRIPTION: 旋转数组
 *
 * @author DaoYuanWang
 * @date 2018/7/31
 */
public class RotateExchange {

    public static void main(String[] args) {

        // 定义50个测试用例
        int testCount = 50;

        int[][] ints = testFactory(testCount);

        // TODO 仍有bug
        for (int i = 0; i < 5; i++) {
            for (int[] anInt : ints) {
                rotate(anInt, i);
            }
        }
    }

    private static int[][] testFactory(int max) {
        int[][] arrs = new int[max + 1][];
        for (int i = 0; i < max; i++) {
            int[] arr = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                arr[j] = j + 1;
            }
            arrs[i] = arr;
        }

        return arrs;
    }

    /**
     * 旋转数组工厂
     *
     * @param nums 要旋转的数组
     * @param k    要旋转的位数
     */
    private static void rotate(int[] nums, int k) {
        if (nums == null) {
            return;
        }

        int len = nums.length;
        k = k % len;

        if (len < 2 || k < 0 || k % len == 0) {
            return;
        }

        if (len == 2) {
            nums[0] = nums[0] + nums[1];
            nums[1] = nums[0] - nums[1];
            nums[0] = nums[0] - nums[1];
            return;
        }

        if (len % 2 == 0) {
            if ((len / 2) % 2 != 0 && k % 2 == 0) {
                rotateEvenHard(nums, len, k);
            } else {
                rotateEven(nums, len, k);
            }
            return;
        }

        rotateOdd(nums, len, k);
    }

    /**
     * (len + k) % 2 != 0
     */
    private static void rotateOdd(int[] arr, int len, int k) {
        // 元素的值 ---> 默认为第0个元素的值
        int tempValue = arr[0];
        // 要移动到的位置 ---> 默认为第0个元素要移动到的位置
        int pos = k % len;

        for (int i = 0; i < len; i++) {
            arr[pos] = tempValue + arr[pos];
            tempValue = arr[pos] - tempValue;
            arr[pos] = arr[pos] - tempValue;

            pos = (pos + k) % len;
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * length % 2 == 0
     */
    private static void rotateEven(int[] arr, int len, int k) {

        int cycle1 = k < len / 2 ? k : len - k;

        for (int j = 0; j < cycle1; j++) {
            int tempValue = arr[j];
            int pos = (k + j) % len;

            for (int i = 0; i < len / cycle1; i++) {
                arr[pos] = tempValue + arr[pos];
                tempValue = arr[pos] - tempValue;
                arr[pos] = arr[pos] - tempValue;

                pos = (pos + k) % len;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * (length / 2) % 2 != 0
     */
    private static void rotateEvenHard(int[] arr, int len, int k) {
        for (int j = 0; j < 2; j++) {
            int tempValue = arr[j];
            int pos = (k + j) % len;

            for (int i = 0; i < len / 2; i++) {
                arr[pos] = tempValue + arr[pos];
                tempValue = arr[pos] - tempValue;
                arr[pos] = arr[pos] - tempValue;

                pos = (pos + k) % len;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


}
