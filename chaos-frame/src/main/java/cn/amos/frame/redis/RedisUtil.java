package cn.amos.frame.redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * Redis 工具类
 *
 * @author DaoyuanWang
 */
public class RedisUtil {

    /**
     * 添加键值
     *
     * @param key   键名
     * @param value 值
     */
    public void set(String key, Object value) {
        Jedis jedis = RedisBase.getRedis();
        if (value != null) {
            jedis.set(key, new Gson().toJson(value));
        }
        RedisBase.closeRedis(jedis);
    }

    /**
     * 添加键值
     *
     * @param key   键名
     * @param value 值
     */
    public void set(String key, String value) {
        Jedis jedis = RedisBase.getRedis();
        if (!isNull(key, value)) {
            jedis.set(key, value);
        }
        RedisBase.closeRedis(jedis);
    }

    /**
     * 添加键值，包含时间
     *
     * @param key   键名
     * @param value 值
     * @param time  时间
     */
    public void set(String key, String value, int time) {
        Jedis jedis = RedisBase.getRedis();
        if (!isNull(key, value)) {
            jedis.set(key, value);
        }
        if (time > 0) {
            jedis.expire(key, time);
        }
        RedisBase.closeRedis(jedis);
    }

    /**
     * 根据键获得值
     *
     * @param key 键名
     * @return 值
     */
    public String get(String key) {
        Jedis jedis = RedisBase.getRedis();
        String value = jedis.get(key);
        RedisBase.closeRedis(jedis);
        return value;
    }

    /**
     * 获得旧值设置新值
     *
     * @param key   键名
     * @param value 新值
     * @return 旧值
     */
    public String getSet(String key, String value) {
        Jedis jedis = RedisBase.getRedis();
        String str = null;
        if (!isNull(key, value)) {
            str = jedis.getSet(key, value);
        }
        RedisBase.closeRedis(jedis);
        return str;
    }

    /**
     * 设置新的key保存时间
     *
     * @param key  键名
     * @param time 时间
     */
    public void setNewTime(String key, int time) {
        Jedis jedis = RedisBase.getRedis();
        // 设置新的时间
        if (jedis.exists(key) && time > 0) {
            jedis.expire(key, time);
        }
        RedisBase.closeRedis(jedis);
    }

    /**
     * 递增值
     *
     * @param key 键名
     * @return 递增后的值
     */
    public Long increment(String key) {
        Jedis jedis = RedisBase.getRedis();
        Long value = null;
        if (jedis.exists(key)) {
            value = jedis.incr(key);
        }
        RedisBase.closeRedis(jedis);
        return value;
    }

    /**
     * 删除键
     *
     * @param key 键名
     */
    public void delete(String key) {
        Jedis jedis = RedisBase.getRedis();
        jedis.del(key);
        RedisBase.closeRedis(jedis);
    }

    /**
     * 判断键是否存在
     *
     * @param key 键名
     * @return 存在否
     */
    public Boolean exists(String key) {
        Jedis jedis = RedisBase.getRedis();
        Boolean boo = jedis.exists(key);
        RedisBase.closeRedis(jedis);
        return boo;
    }

    /**
     * 判断键、值是否为空
     *
     * @param key   键名
     * @param value 值
     * @return 为空否
     */
    private static boolean isNull(String key, String value) {
        if (key == null) {
            System.out.println("Key cannot be null");
        }
        if (value == null) {
            System.out.println("Value cannot be null");
        }
        return value == null || key == null;
    }
}
