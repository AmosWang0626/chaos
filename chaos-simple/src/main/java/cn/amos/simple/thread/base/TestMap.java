package cn.amos.simple.thread.base;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        System.out.println("Main--测试Map使用");
        testHashMap();
    }

    private static void testHashMap() {

        System.out.println("testHashMap--使用");

        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("\t" + simpleDate.format(new Date()));

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("啦啦啦", 110);
        map.put("啦啦啦", 190);
        map.put("啦啦啦", 200);
        map.put("啦啦啦", 270);

        System.out.println("\t总共" + map.size() + "条数据");
        System.out.println("\tKey 为啦啦啦的 Value 是：" + map.get("啦啦啦"));

        System.out.println("\t可见HashMap中不允许出现相同Key的不同数据,并且会更新同Key的值");
    }

}
