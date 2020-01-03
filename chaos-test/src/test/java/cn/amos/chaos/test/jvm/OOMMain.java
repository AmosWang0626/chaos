package cn.amos.chaos.test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION: test oom
 *
 * @author amos.wang
 * @date 2019/11/4
 */
public class OOMMain {

    private static String STR = "string";

    /**
     * -verbose:gc -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath=C:\\Users\\User\\Desktop\\gc
     * -XX:MetaspaceSize=9m -XX:MaxMetaspaceSize=9m
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(STR += STR);
        }
    }

}
