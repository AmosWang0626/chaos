package cn.amos.algorithm.sort;

/**
 * 选择排序
 *
 * @author DaoyuanWang
 */
public class ChooseSort {

    /**
     * 基本原则：
     * 先选一个数，从第一个数开始，用后边的数和选的数比较，如果比选的数小，就记录坐标，直至找到最小的数。
     * 也就是每次循环会找出一个最小数。
     */
    public static void main(String[] args) {
        int arrayLength = 15;

        int[] array = SortUtils.getArray(arrayLength);
        SortUtils.printArr(array, null);

        int count = 0;
        // 选择排序
        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex == i) {
                continue;
            }

            SortUtils.swap(array, i, minIndex);
            SortUtils.printArr(array, ++count);
        }
    }

}
