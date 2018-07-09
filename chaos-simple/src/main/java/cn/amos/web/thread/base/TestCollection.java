package cn.amos.web.thread.base;

import java.util.*;

public class TestCollection {

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

        // 比较ArrayList与HashSet
        /*System.out.println("List和Set都输入同样的数据");
        testArrayList();
        testHashSet();
        testTreeSet();*/

        // 比较ArrayList和LinkedList在List前边插入数据
        TestCollection collection = new TestCollection();
        long time1 = collection.arrayTime() ;
        long time2 = collection.linkedTime();
        System.out.println(time1 + "----" + time2);

    }

    /**
     * List
     * 使用此接口能够精确的控制每个元素插入的位置
     */
    private static void testArrayList() {

        System.out.println("以下是List集合的输出：");

        List<String> list = new ArrayList<String>();
        list.add("ab1");
        list.add("za2");
        list.add("za2");
        list.add("ab3");
        list.add("ab3");
        list.add("gc2");
        list.add("ma2");
        list.add("za1");

        Iterator iterator = list.iterator();
        for (; iterator.hasNext(); ) {
            System.out.print("\t" + iterator.next() + "\t");
        }

        System.out.println("\n\tList没有排序和去重");

        System.out.println("以下是List集合经过Collection.sort()之后的输出：");

        // 对List进行排序
        Collections.sort(list);

        Iterator iterator_sort = list.iterator();
        for (; iterator_sort.hasNext(); ) {
            System.out.print("\t" + iterator_sort.next() + "\t");
        }

        System.out.println("\n\t此时List已彻底排序");
    }

    /**
     * HashSet
     * 不能有重复元素
     * 自动不彻底排序
     */
    private static void testHashSet() {

        System.out.println("以下是HashSet集合的输出：");

        Set<String> set = new HashSet<String>();
        set.add("ab1");
        set.add("za2");
        set.add("za2");
        set.add("ab3");
        set.add("ab3");
        set.add("gc2");
        set.add("ma2");
        set.add("za1");

        Iterator iterator = set.iterator();
        for (; iterator.hasNext(); ) {
            System.out.print("\t" + iterator.next() + "\t");
        }

        System.out.println("\n\tHashSet已经排序并且去重,但可以看出排序不完全");
    }

    /**
     * TreeSet
     * 不能有重复元素
     * 彻底排序
     */
    private static void testTreeSet() {

        System.out.println("以下是TreeSet集合的输出：");

        Set<String> set = new TreeSet<String>();
        set.add("ab1");
        set.add("za2");
        set.add("za2");
        set.add("ab3");
        set.add("ab3");
        set.add("gc2");
        set.add("ma2");
        set.add("za1");

        Iterator iterator = set.iterator();
        for (; iterator.hasNext(); ) {
            System.out.print("\t" + iterator.next() + "\t");
        }

        System.out.println("\n\tTreeSet已彻底排序");
    }

    /**
     * 比较一下ArrayList和LinkedList：
     * 1.ArrayList是基于数组，LinkedList基于链表实现。
     * 2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。
     * 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
     * 4.查找操作indexOf,lastIndexOf,contains等，两者差不多。
     * 这里只是理论上分析，事实上也不一定，比如ArrayList在末尾插入和删除数据就不设计到数据移动
     * 建议：随机访问比较多的话一定要用ArrayList而不是LinkedList，
     * 如果需要频繁的插入和删除应该，考虑用LinkedList来提高性能。
     */
    private long arrayTime() {
        long timeStart = System.currentTimeMillis();
        List<Integer> list_array = new ArrayList<Integer>();
        for (int i = 0; i < 200000; i++) {
            list_array.add(i,null);
        }
        long timeEnd = System.currentTimeMillis();
        long time = timeEnd - timeStart;

        System.out.println("ArrayList 插入100000条数据时间：" + time);
        return time;
    }

    private long linkedTime() {

        long timeStart = System.currentTimeMillis();
        List<Integer> list_linked = new LinkedList<Integer>();
        for (int i = 0; i < 200000; i++) {
            list_linked.add(i,null);
        }
        long timeEnd = System.currentTimeMillis();
        long time = timeEnd - timeStart;

        System.out.println("LinkedList 插入10000条数据时间：" + time);
        return time;
    }

}
