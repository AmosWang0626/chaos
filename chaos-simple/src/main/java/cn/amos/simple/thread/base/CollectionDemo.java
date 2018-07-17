package cn.amos.simple.thread.base;

import java.util.*;

/**
 * @author AmosWang
 */
public class CollectionDemo {

    /**
     * Collection﻿
     * ├List
     * │├LinkedList
     * │├ArrayList
     * │└Vector
     * │　└Stack
     * └Set
     * │├LinkedHashSet
     * │├HashSet
     * <p>
     */
    public static void main(String[] args) {

        // 比较 ArrayList/HashSet/TreeSet
        testArrayList();
        System.out.println("================================================================");
        testHashSet();
        System.out.println("================================================================");
        testTreeSet();
        System.out.println("================================================================");

        // 比较 ArrayList/LinkedList 插入数据
        int size = 20000;
        arrayTime(size);
        linkedTime(size);
    }

    /**
     * List
     * 使用此接口能够精确的控制每个元素插入的位置
     */
    private static void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("ab1");
        list.add("za2");
        list.add("za2");
        list.add("ab3");
        list.add("ab3");
        list.add("gc2");
        list.add("ma2");
        list.add("za1");

        System.out.println("原始List:");
        list.forEach(s -> System.out.print("\t" + s + "\t"));
        System.out.println("\n================================================================");

        System.out.println("以下是Collection.sort(List)之后的输出:");

        // 对List进行排序
        Collections.sort(list);

        list.forEach(s -> System.out.print("\t" + s + "\t"));
        System.out.println("\nArrayList 默认不去重也不排序");
    }

    /**
     * HashSet
     * 不能有重复元素
     * 自动不彻底排序
     */
    private static void testHashSet() {
        System.out.println("以下是HashSet集合的输出:");

        Set<String> set = new HashSet<>();
        set.add("ab1");
        set.add("za2");
        set.add("za2");
        set.add("ab3");
        set.add("ab3");
        set.add("gc2");
        set.add("ma2");
        set.add("za1");

        set.forEach(s -> System.out.print("\t" + s + "\t"));

        System.out.println("\nHashSet 已经排序并且去重,但可以看出排序不完全");
    }

    /**
     * TreeSet
     * 不能有重复元素
     * 彻底排序
     */
    private static void testTreeSet() {
        System.out.println("以下是TreeSet集合的输出:");

        Set<String> set = new TreeSet<>();
        set.add("ab1");
        set.add("za2");
        set.add("za2");
        set.add("ab3");
        set.add("ab3");
        set.add("gc2");
        set.add("ma2");
        set.add("za1");

        set.forEach(s -> System.out.print("\t" + s + "\t"));

        System.out.println("\nTreeSet 去重并彻底排序");
    }

    /**
     * 比较一下ArrayList和LinkedList:
     * 1.ArrayList是基于数组，LinkedList基于链表实现。
     * 2.对于随机访问get和set，ArrayList优于LinkedList，因为LinkedList要移动指针。
     * 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
     * 4.查找操作indexOf,lastIndexOf,contains等，两者差不多。
     * 这里只是理论上分析，事实上也不一定，比如ArrayList在末尾插入和删除数据就不涉及到数据移动
     * 建议:随机访问比较多的话一定要用ArrayList而不是LinkedList，
     * 如果需要频繁的插入和删除应该，考虑用LinkedList来提高性能。
     */
    private static void arrayTime(int size) {
        long timeStart = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        long time = timeEnd - timeStart;

        System.out.println("ArrayList 插入 " + arrayList.size() + " 条数据, 耗时 " + time + " 毫秒");
    }

    private static void linkedTime(int size) {
        long timeStart = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long timeEnd = System.currentTimeMillis();
        long time = timeEnd - timeStart;

        System.out.println("LinkedList 插入 " + linkedList.size() + " 条数据时间: " + time + " 毫秒");
    }

}
