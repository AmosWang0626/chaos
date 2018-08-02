package cn.amos.algorithm;

import java.util.Random;

public class BaseAlg {

    public static void main(String[] args) {
        powerTwo();

        xor();
    }

    /**
     * 判断数字是不是 2 的 n 次幂
     */
    private static void powerTwo() {
        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(20);
            System.out.println(num + "\t--->\t" + (num & (num - 1)));
        }
    }

    /**
     * 异或 ^
     * 相同为 0 ,不同为 1
     */
    private static void xor() {
        int result = 0;

        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(10);
            System.out.print(num + " ^ " + result + " = \t");
            result = num ^ result;
            System.out.println(result);
        }
    }
}
