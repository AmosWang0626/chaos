package cn.amos.simple.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AmosWang
 */
public class MapDemo {

    /**
     * Map
     * --HashMap
     * --HashTable
     * --TreeMap
     */
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("good", "Look");

        map.values().forEach(System.out::println);
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

}
