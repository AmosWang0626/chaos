package cn.amos.frame.redis.stastic;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PROJECT: hello <br>
 * DESCRIPTION: notes
 *
 * @author wangdaoyuan
 * @date 2018/8/30
 */
public class SimpleRedisUtil {

    private static JedisPool jedisPool;

    public static void setJedisPool(JedisPool jedisPool) {
        SimpleRedisUtil.jedisPool = jedisPool;
    }

    private static JedisPool getJedisPool() {
        return jedisPool;
    }

    /*
     * string
     */

    public static void set(String key, String value, int index, Integer second) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);
        jedis.set(key, value);

        // 过期时间
        if (second != null && second != 0) {
            jedis.expire(key, second);
        }

        jedis.close();
    }

    public static String get(String key, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        String hello = jedis.get(key);

        jedis.close();

        return hello;
    }

    public static Long incr(String key, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Long count = jedis.incr(key);

        jedis.close();

        return count;
    }

    public static Long incr(String key, int index, Integer second) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Long count = jedis.incr(key);

        // 过期时间
        if (second != null && second != 0) {
            jedis.expire(key, second);
        }

        jedis.close();

        return count;
    }

    /*
     * key
     */

    public static void del(String key, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        jedis.del(key);

        jedis.close();
    }

    /*
     * list
     */

    /**
     * 最后插入的在列表第一个位置
     */
    public static Long lpush(String key, int index, String... strings) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Long count = jedis.lpush(key, strings);

        jedis.close();

        return count;
    }

    public static List<String> lchange(String key, int index, long start, long end) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        List<String> list = jedis.lrange(key, start, end);

        jedis.close();

        return list;
    }

    /*
     * hash
     */


    public static String hmset(String key, Map<String, String> map, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        String status = jedis.hmset(key, map);

        jedis.close();

        return status;
    }


    public static String hget(String key, String field, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        String value = jedis.hget(key, field);

        jedis.close();

        return value;
    }

    /*
     * set
     */

    public static Long sadd(String key, int index, String... strings) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Long count = jedis.sadd(key, strings);

        jedis.close();

        return count;
    }

    public static Set<String> smembers(String key, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Set<String> members = jedis.smembers(key);

        jedis.close();

        return members;
    }

    /*
     * sort
     */

    public static Long zadd(String key, double score, String member, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Long count = jedis.zadd(key, score, member);

        jedis.close();

        return count;
    }

    public static Long zadd(String key, Map<String, Double> scoreMembers, int index) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Long count = jedis.zadd(key, scoreMembers);

        jedis.close();

        return count;
    }

    public static Set<String> zrange(String key, int index, long start, long end) {
        Jedis jedis = getJedisPool().getResource();
        jedis.select(index);

        Set<String> list = jedis.zrange(key, start, end);

        jedis.close();

        return list;
    }


}
