package cn.amos.simple.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AmosWang
 */
public class MapDemo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * Map
     * --HashMap
     * --HashTable
     * --TreeMap
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("this", "THIS");
        map.put("is", "IS");
        map.put("china", "CHINA");
        map.values().forEach(System.out::println);

        // 获取最近的2的整数次幂
        int num = (1 << 29) - 1;
        System.out.println("num: " + num + ", next: " + testTableSizeFor(num));
    }

    /**
     * 输入参数获取最近的2的整数次幂
     * 1、该算法目的是让最高位的1后面的位全变为1
     * 2、第一句, cap-1再赋值给n的目的是另找到的目标值大于或等于原值. 对于本身就是2的倍数的, 如果不减一, 将会原值翻倍
     *
     * @param cap 输入参数
     * @return 最近的2的整数次幂
     */
    private static int testTableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * HashMap 中不允许出现相同 Key 的键值对, 如果 Key 存在则会更新它的 Value
     */
    private static void testHashMap() {
        String key = "啦啦啦";

        Map<String, Object> map = new HashMap<>(4);

        map.put(key, 110);
        map.put(key, 190);
        map.put(key, 200);
        map.put(key, 270);

        System.out.print("Map Size " + map.size() + ",\t");
        System.out.println("Key " + key + ", Value " + map.get(key));

        System.out.println("即: HashMap 的 Key 必须唯一, Key 存在的话再次 put 会更新其 Value");
    }

    /*
     * HashMap 常量分析
     * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; 初始化Map Size
     * static final int MAXIMUM_CAPACITY = 1 << 30; Map 最大Size
     * static final float DEFAULT_LOAD_FACTOR = 0.75f; 扩容阈值 (if MapSize > (MapSize * factor)) 扩容
     * static final int TREEIFY_THRESHOLD = 8; 当链表长度超过该参数值时将链表转化为红黑树
     * static final int UNTREEIFY_THRESHOLD = 6; 当树的长度小于该参数值时将树转化为链表
     * static final int MIN_TREEIFY_CAPACITY = 64; 要想将链表转化为树, 会首先比较MapSize是否大于该参数值
     */
}
