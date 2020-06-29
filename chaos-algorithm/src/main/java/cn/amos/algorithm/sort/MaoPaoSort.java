package cn.amos.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author DaoyuanWang
 */
public class MaoPaoSort {

    /**
     * 基本原则：两两比较，大的逐步交换到数组末尾。
     * 每次循环找出一个最大数。
     */
    public static void main(String[] args) {
        int arrayLength = 15;

        int[] array = SortUtils.getArray(arrayLength);
        SortUtils.printArr(array, null);

        // 优化标示,如果数组已有序,就无需继续执行了
        int flag;

        // 冒泡排序
        for (int i = 0; i < arrayLength - 1; i++) {
            flag = 0;
            for (int j = 0; j < arrayLength - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    SortUtils.swap(array, j);
                    flag++;
                }
            }

            if (flag == 0) {
                break;
            }

            SortUtils.printArr(array, i + 1);
        }
    }

}
