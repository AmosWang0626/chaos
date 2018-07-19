package cn.amos.simple.base;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/17
 */
public class ShiftDemo {

    public static void main(String[] args) {
        shift();
    }

    /**
     * << n: 2 的 n 次方
     * >> n: 开 2 的 n 次方
     * ^: 异或 [相同为0, 不同为1]
     */
    private static void shift() {
        String hello = "look";
        int h = hello.hashCode();
        System.out.println("look hashCode: " + h);
        System.out.println("look hashCode: " + (h >>> 16));
        System.out.println("look hashCode: " + (h ^ (h >>> 16)));

        // 无符号右移
        h = 10;
        System.out.println(h);
        System.out.println(h >>> 1);
        System.out.println(h >>> 2);

        // 左移
        System.out.println("1 << 4: " + (1 << 4));
        System.out.println("80 << 4: " + (80 << 4));
        System.out.println("10 << 1: " + (10 << 1));
        System.out.println(1 << 30);

        // 右移
        System.out.println(1024 >> 10);

        // 异或
        System.out.println(6 ^ 13);
    }
}
