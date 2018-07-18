package cn.amos.simple.base;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/18
 */
public class TypeDemo {

    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;

        // 右边类型错误: a = a + b;
        a += b;
        System.out.println(a);

        // 小数乘法
        System.out.println(3 * 0.1);

        // 16进制 2147483647
        System.out.println(0x7fffffff);
    }
}
