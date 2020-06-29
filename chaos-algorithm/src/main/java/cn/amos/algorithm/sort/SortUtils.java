package cn.amos.algorithm.sort;

import java.util.Random;

/**
 * DESCRIPTION: 排序工具类
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/6/29
 */
public class SortUtils {

    /**
     * 获取一个数组
     *
     * @param len 数组长度
     * @return 数组
     */
    public static int[] getArray(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = new Random().nextInt(99);
        }

        return array;
    }

    /**
     * arr[i], arr[i+1] = arr[i+1], arr[i]
     *
     * @param arr 数组
     * @param i   index
     */
    public static void swap(int[] arr, int i) {
        arr[i] = arr[i] + arr[i + 1];
        arr[i + 1] = arr[i] - arr[i + 1];
        arr[i] = arr[i] - arr[i + 1];
    }

    /**
     * arr[i], arr[j] = arr[j], arr[i]
     *
     * @param arr 数组
     * @param i   index1
     * @param j   index2
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * 打印数组
     *
     * @param arr 数组
     * @param num 第几次排序，可为空
     */
    public static void printArr(int[] arr, Integer num) {
        if (num != null) {
            System.out.print("[第 " + num + "\t次] 排序:\t");
        } else {
            System.out.print("\t原始数组为:\t\t");
        }

        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
