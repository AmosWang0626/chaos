package cn.amos.simple.thread.base;

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

        h = 10;
        System.out.println(h);
        System.out.println(h >>> 1);
        System.out.println(h >>> 2);

        System.out.println(1 << 4);
        System.out.println(1 << 30);
        System.out.println(1024 >> 10);
        System.out.println(6 ^ 13);
    }
}
