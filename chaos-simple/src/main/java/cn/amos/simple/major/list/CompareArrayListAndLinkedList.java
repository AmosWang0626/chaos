package cn.amos.simple.major.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * PROJECT: chaos
 * NOTE: 比较ArrayList 与LinkedList
 *
 * @author AMOS
 * @date 2018/8/4 18:29
 * @see ArrayList 数组集合
 * @see LinkedList 链表集合
 */
public class CompareArrayListAndLinkedList {

    private static List<Integer> sLinkedList;
    private static List<Integer> sArrayList;

    /**
     * 比较一下ArrayList和LinkedList:
     * <p>
     * 1.ArrayList是基于数组，LinkedList基于链表实现。
     * 2.对于随机访问get和set，ArrayList优于LinkedList，因为LinkedList要移动指针。
     * 3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
     * 4.查找操作indexOf,lastIndexOf,contains等，两者差不多。
     * <p>
     * eg.这里只是理论上分析，事实上也不一定，比如ArrayList在末尾插入和删除数据就不涉及到数据移动
     * 建议:随机访问比较多的话一定要用ArrayList而不是LinkedList，如果需要频繁的插入和删除应该，考虑用LinkedList来提高性能。
     */
    public static void main(String[] args) {
        // insertCompare();

        selectCompare();
    }

    /**
     * 方便记忆: LinkedList随机访问、修改需要移动指针,所以慢
     * <p>
     * ArrayList 随机访问 20000 条数据, 耗时 8 毫秒
     * LinkedList 随机访问 20000 条数据, 耗时 467 毫秒
     */
    private static void selectCompare() {
        Random random = new Random();

        // 随机访问size条数据
        int size = 20000;
        arrayTime(size, false);
        linkedTime(size, false);

        System.out.println("ArrayList 随机访问 " + size + " 条数据, 耗时 " + selectArrayListTime(size, random) + " 毫秒");
        System.out.println("LinkedList 随机访问 " + size + " 条数据, 耗时 " + selectLinkedListTime(size, random) + " 毫秒");
    }

    private static long selectArrayListTime(int size, Random random) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            sArrayList.get(random.nextInt(size - 1));
        }

        return System.currentTimeMillis() - timeStart;
    }

    private static long selectLinkedListTime(int size, Random random) {
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            sLinkedList.get(random.nextInt(size - 1));
        }

        return System.currentTimeMillis() - timeStart;

    }

    /**
     * 方便记忆: ArrayList 插入数据、删除数据需要移动元素,所以慢
     * <p>
     * ArrayList 首位置插入 20000 条数据, 耗时 112 毫秒
     * LinkedList 首位置插入 20000 条数据, 耗时 8 毫秒
     * <p>
     * 不一定: 例如都在末尾插入数据、删除数据就差不多
     * ArrayList 默认插入 20000 条数据, 耗时 5 毫秒
     * LinkedList 默认插入 20000 条数据, 耗时 4 毫秒
     */
    private static void insertCompare() {
        // 同时插入size条数据
        int size = 20000;

        System.out.println("ArrayList 首位置插入 " + size + " 条数据, 耗时 " + arrayTime(size, true) + " 毫秒");
        System.out.println("LinkedList 首位置插入 " + size + " 条数据, 耗时 " + linkedTime(size, true) + " 毫秒");
        System.out.println("ArrayList 默认插入 " + size + " 条数据, 耗时 " + arrayTime(size, false) + " 毫秒");
        System.out.println("LinkedList 默认插入 " + size + " 条数据, 耗时 " + linkedTime(size, false) + " 毫秒");
    }

    /**
     * ArrayList 插入数据
     *
     * @param size 插入条数
     * @param pos  true: 首位置插入; false: 末尾插入
     */
    private static long arrayTime(int size, boolean pos) {
        long timeStart = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            if (pos) {
                arrayList.add(0, i);
            } else {
                arrayList.add(i);
            }
        }

        // 测试查询使用
        sArrayList = arrayList;

        return System.currentTimeMillis() - timeStart;

    }

    /**
     * LinkedList 插入数据
     *
     * @param size 插入条数
     * @param pos  true: 首位置插入; false: 末尾插入
     */
    private static long linkedTime(int size, boolean pos) {
        long timeStart = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (pos) {
                linkedList.add(0, i);
            } else {
                linkedList.add(i);
            }
        }

        // 测试查询使用
        sLinkedList = linkedList;

        return System.currentTimeMillis() - timeStart;
    }

}
