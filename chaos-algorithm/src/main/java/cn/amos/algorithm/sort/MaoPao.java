package cn.amos.algorithm.sort;

import java.util.Random;

/**
 * @author DaoyuanWang
 */
public class MaoPao {

    public static void main(String[] args) {
        // 产生 n 个随机数
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(70);
        }
        printArr(array, 0);

        // 如果已有序排列,则根据count结束for循环
        int count;

        // 冒泡排序
        for (int i = 0; i < array.length - 1; i++) {
            count = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                } else {
                    count++;
                }
            }

            if (count == array.length - i - 1) {
                return;
            }

            // 每次排序后遍历输出
            printArr(array, i + 1);
        }
    }

    /**
     * arr[j] 与 arr[j+1] 内容交换
     * <code>
     * int[] arr = new int[]{89, 10};
     * System.out.println("num1: " + arr[0] + ", num2: " + arr[1]);
     * swap(arr, 0);
     * System.out.println("num1: " + arr[0] + ", num2: " + arr[1]);
     * </code>
     *
     * @param array 数组
     * @param index index
     */
    private static void swap(int[] array, int index) {
        array[index] = array[index] + array[index + 1];
        array[index + 1] = array[index] - array[index + 1];
        array[index] = array[index] - array[index + 1];
    }

    private static void printArr(int[] arr, int num) {
        System.out.print("第\t" + num + "\t次排序:\t");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}
