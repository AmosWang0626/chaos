package cn.amos.algorithm.array;

import java.util.Arrays;
import java.util.Random;

/**
 * PROJECT: chaos
 * <p>
 * NOTE:
 * 接收一个整数length，返回一个数组，数组的长度为length,
 * 数组中的元素为随机的(0 ~ length－1)的值，不能重复。
 * eg.length = 5, return [1,0,3,2,4]
 * </p>
 *
 * @author AMOS
 * @date 2018/8/4 9:07
 */
public class RandomByLength {

    public static void main(String[] args) {
        int len = 5;
        System.out.println(Arrays.toString(randomByLength(len)));
    }

    private static int[] randomByLength(int len) {
        int[] arr = new int[len];
        int count = 0;

        while (count < len - 1) {
            // 初始化长度的数组,所有元素默认为0,
            // 所以只需生成0~3之间数字即可,之后+1,得1~4
            int num = new Random().nextInt(len - 1) + 1;
            boolean temp = true;
            for (int anArr : arr) {
                if (anArr == num) {
                    temp = false;
                }
            }
            if (temp) {
                arr[count] = num;
                count++;
            }
        }

        return arr;
    }
}
