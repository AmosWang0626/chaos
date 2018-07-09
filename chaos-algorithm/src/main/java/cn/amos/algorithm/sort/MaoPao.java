package cn.amos.algorithm.sort;

import java.util.Random;

public class MaoPao {

    public static void main(String[] args) {
        int[] array = new int[15];
        boolean boo;

        // 随机产生数据并输出
        System.out.print("0原始：");
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(30);
            System.out.print(array[i] + "\t");
        }

        // 冒泡排序
        for (int i = 0; i < array.length - 1; i++) {

            boo = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j);
                    boo = true;
                }
            }
            // 每次排序后遍历输出
            System.out.print("\n第" + (i + 1) + "次，");
            for (int num : array) {
                System.out.print(num + "\t");
            }
            if (!boo) {
                return;
            }
        }
    }

    private static void swap(int[] array, int j) {
        array[j] = array[j] + array[j + 1];
        array[j + 1] = array[j] - array[j + 1];
        array[j] = array[j] - array[j + 1];
    }

}
