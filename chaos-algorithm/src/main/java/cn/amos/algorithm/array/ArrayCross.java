package cn.amos.algorithm.array;

import java.util.Arrays;

/**
 * 模块名称: chaos
 * 模块描述: 两个数组交集
 *
 * @author amos.wang
 * @date 2020/6/22 18:58
 */
public class ArrayCross {

    public static void main(String[] args) {
        /// random array
//        final int arr1 = 20;
//        int[] nums1 = new int[arr1];
//        for (int i = 0; i < arr1; i++) {
//            nums1[i] = new Random().nextInt(50);
//        }
//        final int arr2 = 30;
//        int[] nums2 = new int[arr2];
//        for (int i = 0; i < arr2; i++) {
//            nums2[i] = new Random().nextInt(50);
//        }
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));

        int[] nums1 = {61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12, 86, 58, 77, 30, 64, 46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30, 67, 34, 62, 35, 47, 98, 3, 41, 53, 26, 66, 40, 54, 44, 57, 46, 70, 60, 4, 63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82, 66, 98, 6, 92, 31, 43, 81, 88, 60, 10, 55, 66, 82, 0, 79, 11, 81};
        int[] nums2 = {5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92, 84, 38, 85, 34, 16, 6, 99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
//        System.out.println(Arrays.toString(removeByIndex(nums2, 1)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // 空数组
        int[] nil = {};

        if (nums1.length == 0 || nums2.length == 0) {
            return nil;
        }

        // leftArr 为数目较多的数组
        int[] leftArr;
        int[] rightArr;

        if (nums1.length > nums2.length) {
            leftArr = nums1;
            rightArr = nums2;
        } else {
            leftArr = nums2;
            rightArr = nums1;
        }

        // 数组指针
        int index = 0;
        // 初始化数组, 重复的个数最大为 rightArr.length
        int[] crossArr = new int[rightArr.length];

        for (int left : leftArr) {
            for (int i = 0; i < rightArr.length; i++) {
                if (left == rightArr[i]) {
                    crossArr[index] = left;
                    index++;
                    rightArr = removeByIndex(rightArr, i);
                    
                    // 至关重要!!!
                    break;
                }
            }
        }

        if (index == 0) {
            return nil;
        }

        int[] tempArr = new int[index];
        if (index >= 0) {
            System.arraycopy(crossArr, 0, tempArr, 0, index);
        }

        return tempArr;
    }

    public static int[] removeByIndex(int[] arr, int index) {
        int tempIndex = 0;
        int[] temp = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            temp[tempIndex] = arr[i];
            tempIndex++;
        }

        return temp;
    }

}
