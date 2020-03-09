package cn.amos.chaos.test.jvm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * DESCRIPTION: JavaTest
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/9
 */
public class JavaTest {

    private Map<String, Integer> BASE_MAP = new HashMap<>();

    public static void main(String[] args) {
        int num = hello();
        System.out.println(num);
    }

    public static int hello() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("amos", 666);
        System.out.println("hello map: " + map);

        int numTen = 10;
        int numHundred = 100;
        boolean flag = new Random().nextBoolean();
        if (flag) {
            System.out.println(numTen);
        }
        numHundred += numTen;
        return numHundred;
    }

}
