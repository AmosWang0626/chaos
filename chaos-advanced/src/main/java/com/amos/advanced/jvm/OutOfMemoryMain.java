package com.amos.advanced.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION: 测试内存溢出
 *
 * @author amos.wang
 * @date 2019/11/4
 */
public class OutOfMemoryMain {

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
