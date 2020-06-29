package cn.amos.algorithm.sort;

/**
 * 插入排序
 *
 * @author DaoyuanWang
 */
public class InsertSort {

    /**
     * 基本原则：从第二个数开始，如果比前边的数小，就和前边的交换位置，直至找到正确位置。
     * 每次为一个数找到正确位置。
     * 23 18 50
     */
    public static void main(String[] args) {
        int arrayLength = 15;

        int[] array = SortUtils.getArray(arrayLength);
        SortUtils.printArr(array, null);

        int count = 0;
        // 插入排序
        for (int i = 1; i < arrayLength; i++) {
            int currentIndex = i;
            boolean move = false;
            for (int j = i - 1; j >= 0; j--) {
                if (array[currentIndex] < array[j]) {
                    SortUtils.swap(array, currentIndex, j);
                    currentIndex = j;
                    move = true;
                } else {
                    break;
                }
            }
            if (move) {
                SortUtils.printArr(array, ++count);
            }
        }
    }

}
