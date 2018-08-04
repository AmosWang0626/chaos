package cn.amos.algorithm.array;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
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
        int len = 10000;
        new Thread(() -> test("randomByLength", len)).start();
        new Thread(() -> test("randomByLength2", len)).start();
    }

    private static void test(String funName, int len) {
        Method method;

        long startTime = System.currentTimeMillis();
        System.out.println("开始执行: " + startTime);
        try {
            method = RandomByLength.class.getDeclaredMethod(funName, int.class);
            method.invoke(null, len);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(funName + "执行完成，耗时(ms): " + (System.currentTimeMillis() - startTime));
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

    private static int[] randomByLength2(int len) {
        List<Integer> list = new LinkedList<>();

        Random random = new Random();

        for (int i = 0; i < len; i++) {
            list.add(i);
        }


        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = list.remove(random.nextInt(len - i));
        }

        return arr;
    }
}
