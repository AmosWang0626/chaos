package cn.amos.algorithm.array;

/**
 * PROJECT: chaos
 * DESCRIPTION: 删除重复数字
 *
 * @author DaoYuanWang
 * @date 2018/7/30
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 5, 5, 6};
        System.out.print("原始array: ");
        for (int i : nums) {
            System.out.print(i + "\t\t");
        }

        int duplicates = removeDuplicates(nums);
        System.out.println("\n去重后长度: " + duplicates);

        System.out.print("去重array: ");
        for (int i : nums) {
            System.out.print(i + "\t\t");
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int temp = nums[0];
        int len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[len] = nums[i];
                len++;
            }
        }

        return len;
    }
}
