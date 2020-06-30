package cn.amos.algorithm.sort;

/**
 * 快速排序
 *
 * @author DaoyuanWang
 */
public class QuickSort {

    /**
     * 基本原则：找一个元素，确定 low 和 high 坐标。
     * 开始从 high 往前比较，如果 high处元素 大于 low处元素，high--，否则 arr[low, high] = arr[high, low]。
     * 接着从 low 往后比较，如果 low处元素 小于 high处元素，low++，否则 arr[low, high] = arr[high, low]。
     * <p>
     * 每次循环确定一个元素位置，但是同时也调整好了许多元素位置。
     */
    public static void main(String[] args) {
        int arrayLength = 15;

        int[] arr = SortUtils.getArray(arrayLength);
        SortUtils.printArr(arr, null);

        sort(arr, 0, arrayLength - 1);
        SortUtils.printArr(arr, 0);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int index = find(arr, low, high);
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }

    private static int find(int[] arr, int low, int high) {
        int star = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= star) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= star) {
                low++;
            }
            arr[high] = arr[low];

            if (low == high) {
                break;
            }
        }
        arr[low] = star;

        return low;
    }

}
