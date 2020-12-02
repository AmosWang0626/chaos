package com.amos.advanced.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模块名称: chaos
 * 模块描述: 分批提交
 *
 * @author amos.wang
 * @date 2020/12/1 18:00
 */
public class BatchSubmitMain {

    public static void main(String[] args) {
        map();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        list();
    }

    private static void map() {
        Map<String, String> mapList = new ConcurrentHashMap<>();
        for (int i = 0; i < 127; i++) {
            mapList.put(String.valueOf(i), "测试数据" + i);
        }

        int submit = 20;

        AtomicInteger splitIndex = new AtomicInteger(1);
        AtomicInteger index = new AtomicInteger(0);

        mapList.forEach((key, value) -> {
            int i = index.incrementAndGet();

            if (i / submit < splitIndex.get()) {

                System.out.print(value + "\t");
            } else {

                // 提交数据
                System.out.printf("\n创建意图 & 训练语料完成！[%s~%s][总数据：%s]\n", (splitIndex.get() - 1) * submit, splitIndex.get() * submit, mapList.size());
                splitIndex.incrementAndGet();
            }

            if (i == mapList.size()) {
                // 提交数据
                System.out.printf("\n创建意图 & 训练语料完成！[%s~%s][总数据：%s]\n", (splitIndex.get() - 1) * submit, mapList.size(), mapList.size());
                splitIndex.incrementAndGet();
            }
        });
    }

    private static void list() {
        List<String> mapList = new ArrayList<>();
        for (int i = 0; i < 127; i++) {
            mapList.add("测试数据" + i);
        }

        int submit = 20;
        int len = 127 / submit;

        for (int i = 0; i < len; i++) {
            System.out.println(String.join("\t", mapList.subList(submit * i, submit * (i + 1))));
            System.out.printf("创建意图 & 训练语料完成！[%s~%s][总数据：%s]\n", i * submit, (i + 1) * submit, mapList.size());
        }

        System.out.println(String.join("\t", mapList.subList(submit * len, mapList.size())));
        System.out.printf("创建意图 & 训练语料完成！[%s~%s][总数据：%s]\n", submit * len, mapList.size(), mapList.size());
    }

}

