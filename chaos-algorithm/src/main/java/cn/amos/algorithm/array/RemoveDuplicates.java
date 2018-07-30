package cn.amos.algorithm.array;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/30
 */
public class RemoveDuplicates {

    private static int[] arr = null;

    public static void main(String[] args) {
        arr = new int[]{1, 1, 1, 2, 5, 5, 6};
        System.out.print("原始array: ");
        for (int i : arr) {
            System.out.print(i + "\t\t");
        }

        int duplicates = removeDuplicates();
        System.out.println("\n去重后长度: " + duplicates);

        System.out.print("去重array: ");
        for (int i : arr) {
            System.out.print(i + "\t\t");
        }
    }

    private static int removeDuplicates() {
        int temp = arr[0];
        int len = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != temp) {
                temp = arr[i];
                arr[len] = arr[i];
                len++;
            }
        }

        return len;
    }
}
