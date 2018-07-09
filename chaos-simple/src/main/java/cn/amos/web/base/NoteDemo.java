package cn.amos.web.base;

import java.util.Random;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote 注释相关demo
 * @date 2018/2/8
 */
public class NoteDemo {

    public static void main(String[] args) {
        try {
            System.out.println(helloWorld(new Random().nextInt(3) + " amos"));
            System.out.println(hello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * hello World
     * {@code System.out.println(return)}
     * {@code hello}
     *
     * @param name <strong>名字</strong>
     * @return 沉思良久想说的一句话
     * @throws Exception 异常信息
     */
    private static String helloWorld(String name) throws Exception {
        return "Hello World " + name + "!";
    }

    /**
     * hello World
     *
     * @return 666
     * @see StringDemo#hello()
     * @see <a href="www.baidu.com">666</a>
     */
    private static String hello() {
        return new StringDemo().hello();
    }
}
