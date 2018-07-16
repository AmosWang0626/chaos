package cn.amos.simple.thread.base;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    /**
     * Map
     * --HashMap
     * --HashTable
     * --TreeMap
     */
    public static void main(String[] args) {
        testHashMap();
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

        System.out.println("Map 共" + map.size() + "条数据");
        System.out.println("Key 为 " + key + " 的 Value 是: " + map.get(key));

        System.out.println("可见HashMap中不允许出现相同Key的不同数据,并且会更新同Key的值");
    }

}
