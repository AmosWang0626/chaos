package com.amos.advanced.jvm;

/**
 * PROJECT: interview
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/29
 */
public class StackGarbageCollection {

    private static int a;

    /**
     * 运行jvm config
     * print gc process
     * -verbose:gc
     */
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        byte[] bytes = new byte[1024 * 1000 * 1000];
        System.gc();
    }

    public static void test2() {
        {
            byte[] bytes = new byte[1024 * 1000 * 1000];
        }
        System.gc();
    }

    public static void test3() {
        {
            byte[] bytes = new byte[1024 * 1000 * 1000];
        }
        int a = 0;
        System.gc();
    }

    private static void hello() {
        // 注意下边操作是无效的
        // int a;
        System.out.println(a);
    }

}
