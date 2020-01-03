package cn.amos.chaos.test.jvm;

/**
 * DESCRIPTION: 测试下 sof
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
            System.out.println("sof error, this count is " + test.count);
            e.printStackTrace();
        }
    }

    static class Test {
        private static int count;
        void increment() {
            count++;
            increment();
        }
    }

}
