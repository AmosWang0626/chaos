package cn.amos.common.simple.major.map;

import java.util.HashMap;
import java.util.Map;

/**
 * PROJECT: chaos
 * NOTE: 类说明
 *
 * @author AMOS
 * @date 2018/8/4 16:01
 */
public class HashMapDemo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        int initSize = 9;
        System.out.println("初始化size为" + initSize
                + ", 大于等于它, 并且为2的n次方的数字为"
                + tableSizeFor(initSize));

        System.out.println();

        sameKey();
    }

    /**
     * 输入参数获取最近的2的整数次幂
     * 1、该算法目的是让最高位的1后面的位全变为1
     * 2、第一句, cap-1再赋值给n的目的是另找到的目标值大于或等于原值. 对于本身就是2的倍数的, 如果不减一, 将会原值翻倍
     *
     * @param cap 输入参数
     * @return 最近的2的整数次幂
     */
    private static int tableSizeFor(int cap) {
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
    private static void sameKey() {
        String key = "啦啦啦";

        Map<String, Object> map = new HashMap<>(4);

        map.put(key, 110);
        map.put(key, 190);
        map.put(key, 200);
        map.put(key, 270);

        System.out.println("MapSize = " + map.size() + ", Key = " + key + ", Value = " + map.get(key));

        System.out.println("So, HashMap key only, put again, will set new value");
    }

    /*
     * HashMap 1.8 常量分析
     * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; 初始化桶数量
     * static final int MAXIMUM_CAPACITY = 1 << 30; Map 最大Size
     * static final float DEFAULT_LOAD_FACTOR = 0.75f; 扩容阈值 (if MapSize > (MapSize * factor)) 扩容
     * static final int TREEIFY_THRESHOLD = 8; 当链表长度超过该参数值时将链表转化为红黑树
     * static final int UNTREEIFY_THRESHOLD = 6; 当树的长度小于该参数值时将树转化为链表
     * static final int MIN_TREEIFY_CAPACITY = 64; 要想将链表转化为树, 会首先比较Map Size是否大于该参数值
     *
     * capacity = 桶数量
     *
     * threshold = capacity * load_factor 容量大于等于这个即扩容
     *
     * 当好多bin被映射到同一个桶时，如果这个桶中bin的数量小于 TREEIFY_THRESHOLD 当然不会转化成树形结构存储；
     * 如果这个桶中bin的数量大于了 TREEIFY_THRESHOLD，但是 capacity 小于 MIN_TREEIFY_CAPACITY 则依然使用链表结构进行存储，
     * 此时会对HashMap进行扩容；如果capacity大于了MIN_TREEIFY_CAPACITY ，则会进行树化。
     */
}
