package cn.amos.simple.base;

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
        others();
        integerType();
        byteType();
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
}
