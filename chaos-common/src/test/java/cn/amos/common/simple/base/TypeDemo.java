package cn.amos.common.simple.base;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/18
 */
public class TypeDemo {

    /**
     * 1字节： byte , boolean
     * 2字节： short , char
     * 4字节： int , float
     * 8字节： long , double
     * 注：1字节(byte)=8位(bits)
     */

    public static void main(String[] args) {
        // others();
        // integerType();
        // byteType();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(1 << 31);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Math.pow(2, 32));

        // =====================
        System.out.println(Math.pow(2, 10));
        System.out.println(sum(100));
    }

    private static void others() {
        // 小数乘法
        System.out.println("[3 * 0.1]: " + 3 * 0.1);

        // 16进制 2147483647
        System.out.println("[0x7fffffff]: " + 0x7fffffff);
    }

    private static void integerType() {
        // 在Java 5及更高版本中不需要显式装箱与拆箱
        // 装箱与拆箱如下:
        Integer num = Integer.valueOf(100);
        int realVal = num.intValue();
        System.out.println(realVal);

        Integer num1 = 127;
        Integer num2 = 127;

        Integer num3 = 256;
        Integer num4 = 256;

        System.out.println(num1 == num2);
        System.out.println(num3 == num4);
    }

    private static void byteType() {
        System.out.println(1 << 8);

        // byte -- 1字节 -- 8bit -- 最高位为符号位
        // min: -128; max: 127
        byte a = 127;
        byte b = 1;

        // 右句类型错误Exception: a = a + b;
        a++;
        System.out.println(a);
    }


    /**
     * 递归加法
     */
    private static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }

    /**
     * 测试switch break
     */
    private void test0() {
        char c = 'A';
        int num = 10;
        switch (c) {
            case 'A':
                num++;
            case 'Y':
                num++;
                break;
            default:
                num--;
        }
        System.out.println(num);
    }

    /**
     * 测试long与int相加
     */
    public void test1() {
//         long num = 100;
//         int x = num + 2;
//         System.out.println(x);
    }

    /**
     * 测试int与long相加
     */
    public void test2() {
        int num = 100;
        long x = num + 2;
        System.out.println(x);
    }

    /**
     * 测试int的最大值
     */
    public void test4() {
        int i1 = (int) Math.pow(2, 31); // 2147483647
        // int i2 = (int) Math.pow(2, 32); // 2147483647
        int i3 = (int) Math.pow(2, 31) + 1; // -2147483648
        int i4 = (int) Math.pow(2, 31) + 2; // -2147483647
        System.out.println("Max int is " + i1 + "\nAnd Max int +1 is " + i3 + "\nAnd Max int +2 is " + i4);
    }
}
