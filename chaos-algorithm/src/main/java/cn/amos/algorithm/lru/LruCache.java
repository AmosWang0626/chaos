package cn.amos.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DESCRIPTION: LRU缓存测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/10/15
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    private final int cache_size;

    public LruCache(int size) {
        super((int) Math.ceil(size / 0.75), 0.75f, true);
        cache_size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cache_size;
    }

    public static void main(String[] args) {
        int size = 3;

        LruCache<String, Integer> lruCache = new LruCache<>(size);

        lruCache.put("AMOS", 18);
        lruCache.put("GRACE", 18);
        lruCache.put("DUDU", 18);
        lruCache.put("DY", 18);
        lruCache.put("ddyy", 18);

        System.out.println(lruCache);
    }

}
