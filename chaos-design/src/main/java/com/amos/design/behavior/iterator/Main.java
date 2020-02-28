package com.amos.design.behavior.iterator;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 迭代器
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        BaseCluster<String> cluster = new StringCluster();
        int success = cluster.add("100", "101", "102", "103");
        System.out.println("保存成功数据数量：" + success);

        BaseIterator<String> iterator = new IteratorImpl<>(cluster);
        iterator.range();
    }

}
