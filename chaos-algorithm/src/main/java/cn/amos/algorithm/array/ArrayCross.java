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
        int[] nums1 = new int[]{1, 4, 6, 7, 2, 8};
        int[] nums2 = new int[]{2, 5, 7, 4, 8, 9};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
//        int nums1length = nums1.length;
//        int nums2length = nums2.length;
//        // index && mergeNums
//        int index = 0;
//        int[] mergeNums = new int[Math.min(nums1length, nums2length)];
//
//        int surplusIndex = 0;
//        if (nums1length < nums2length) {
//            for (int i : nums1) {
//                for (int j = 0; j < nums2length - surplusIndex; j++) {
//                    if (i == nums2[j]) {
//                        surplusIndex++;
//                    }
//                }
//            }
//        }

        return null;
    }

}
