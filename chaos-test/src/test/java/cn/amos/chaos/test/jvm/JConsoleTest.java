package cn.amos.chaos.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION: JConsoleTest
 * jvisualvm、jconsole 两个神奇（jconsole更精细）
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/3/10
 */
public class JConsoleTest {

    static class Demo {
        // 20k
        byte[] bytes = new byte[1024 * 20];
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("准备开始，倒计时5秒钟");
        Thread.sleep(5000);

        System.out.println("执行开始。。。");
        List<Demo> list = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            Thread.sleep(200);
            list.add(new Demo());
        }
        System.out.println(list.size());
    }

}
