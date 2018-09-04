package cn.amos.frame.funcoding;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */

public class InterFun {

    /**
     * 以下注解的意思是函数式编程,也就是只允许有一个方法
     */
    @FunctionalInterface
    interface Message {
        void print();
    }

    public static void main(String[] args) {
        // 传统方式
        Message message = new Message() {
            @Override
            public void print() {
                System.out.println("hello world!");
            }
        };
        message.print();

        // Lambda(函数式编程)
        Message funMessage = () -> System.out.println("HELLO WORLD");
        funMessage.print();
    }


}
