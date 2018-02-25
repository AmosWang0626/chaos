package cn.amos.simple.base;

/**
 * @author Amos
 */
public class BaseType {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 10));
        System.out.println(sum(100));
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
