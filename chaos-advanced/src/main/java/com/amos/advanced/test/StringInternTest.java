package com.amos.advanced.test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.Random;

/**
 * DESCRIPTION: String.intern() Test
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public class StringInternTest {

    private static final Integer MAX = 1000 * 10000;
    private static final String[] ARRAY = new String[MAX];


    public static void main(String[] args) {
        MemoryMXBean memoryParam = ManagementFactory.getMemoryMXBean();
        System.out.println("堆内存信息: " + memoryParam.getHeapMemoryUsage());
        System.out.println("方法区内存信息: " + memoryParam.getNonHeapMemoryUsage());
        System.out.println("\n##################### 运行时设置的JVM参数 #######################");
        System.out.println(ManagementFactory.getRuntimeMXBean().getInputArguments());


        Integer[] dataArr = new Integer[10];
        Random random = new Random(100000);
        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = random.nextInt();
        }
        System.out.println("\n开始执行程序");
        long time = System.currentTimeMillis();

        for (int i = 0; i < MAX; i++) {
            /// 不使用.intern()
//            ARRAY[i] = new String(String.valueOf(dataArr[i % dataArr.length]));
            /// 使用.intern()
            ARRAY[i] = new String(String.valueOf(dataArr[i % dataArr.length])).intern();
        }

        time = System.currentTimeMillis() - time;
        System.out.println("程序执行完成，耗时: " + time);
        System.gc();
    }

}
