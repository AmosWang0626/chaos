package cn.amos.frame.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis工具类
 *
 * @author DaoyuanWang
 */
public class RedisBase {

    private static final Long SUCCESS = 1L;
    private static final String HOST = "112.74.57.49";
    private static final Integer PORT = 6379;
    private static final Integer TIMEOUT = 2000;
    private static final String PASSWORD = "root";
    private static final Integer DATABASE = 10;

    /**
     * 注意下边连接的三步的顺序
     * 一、host 以及端口
     * 二、设置连接密码
     * 三、设置连接的第几个Redis数据库
     */
    public static void main(String[] args) {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.auth("root");
        String user = jedis.get("user");
        System.out.println(user);
    }

    private static Jedis redisBase() {

        Jedis jedis = new Jedis(HOST, PORT);
        jedis.auth("root");
        jedis.select(0);

        return jedis;
    }

    /**
     * 获得Redis
     */
    protected static Jedis getRedis() {

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(500);
        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(200);

        // 获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, HOST, PORT, TIMEOUT, PASSWORD, DATABASE);

        return jedisPool.getResource();
    }

    /**
     * 关闭Redis
     */
    protected static void closeRedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
