package com.amos.advanced.jvm;

/**
 * DESCRIPTION: 栈溢出测试
 *
 * @author amos.wang
 * @date 2019/11/4
 */
public class StackOverflowMain {

    public static void main(String[] args) {
        // will throw java.lang.StackOverflowError
        Test test = new Test();
        try {
            test.increment();
        } catch (StackOverflowError e) {
            System.out.println("sof error, this count is " + Test.count);
            e.printStackTrace();
        }
    }

    public static class Test {
        private static int count;

        public void increment() {
            count++;
            increment();
        }
    }

}
