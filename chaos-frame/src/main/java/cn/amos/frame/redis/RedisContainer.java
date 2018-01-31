package cn.amos.frame.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.util.UUID;

/**
 * @author DaoyuanWang
 * @apiNote Redis 基础容器
 * @date 2018/1/31
 */
public class RedisContainer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisContainer.class);

    /**
     * redis 连接池
     */
    private JedisPool jedisPool;
    /**
     * 默认选择第0个数据库
     */
    private int dbIndex = 0;

    public RedisContainer(String host, int port, String password, int dbIndex) {
        this(host, port, password);
        this.dbIndex = dbIndex;
    }

    private RedisContainer(String host, int port, String password) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 设置最大连接数
        jedisPoolConfig.setMaxTotal(500);
        // 设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(200);
        jedisPool = new JedisPool(jedisPoolConfig, host, port, Protocol.DEFAULT_TIMEOUT, password);
    }

    /**
     * 获取 Redis
     */
    private Jedis getRedis() {
        Jedis jedis = jedisPool.getResource();
        jedis.select(dbIndex);
        return jedis;
    }

    /**
     * 关闭 Redis
     */
    private void release(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 添加键值
     *
     * @param key   键名
     * @param value 值 Object
     */
    public void set(String key, Object value) {
        if (hasNull(key, value)) {
            return;
        }
        Jedis jedis = getRedis();
        if (value instanceof String) {
            jedis.set(key, (String) value);
        } else {
            jedis.set(key, JSON.toJSONString(value));
        }
        release(jedis);
    }

    /**
     * 添加键值，包含时间
     *
     * @param key   键名
     * @param value 值
     * @param time  时间
     */
    public void set(String key, Object value, int time) {
        if (hasNull(key, value)) {
            return;
        }
        Jedis jedis = getRedis();
        if (value instanceof String) {
            jedis.set(key, (String) value);
        } else {
            jedis.set(key, JSON.toJSONString(value));
        }
        if (time > 0) {
            jedis.expire(key, time);
        }
        release(jedis);
    }

    /**
     * 根据键获得值
     *
     * @param key 键名
     * @return 值
     */
    public String get(String key) {
        if (isNull(key)) {
            return null;
        }
        Jedis jedis = getRedis();
        String value = jedis.get(key);
        release(jedis);
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
        if (hasNull(key, value)) {
            return null;
        }
        Jedis jedis = getRedis();
        String str = jedis.getSet(key, value);
        release(jedis);
        return str;
    }

    /**
     * 设置新的key保存时间
     *
     * @param key  键名
     * @param time 时间
     */
    public void setNewTime(String key, int time) {
        if (isNull(key) || time <= 0) {
            return;
        }
        Jedis jedis = getRedis();
        // 设置新的时间
        if (jedis.exists(key)) {
            jedis.expire(key, time);
        }
        release(jedis);
    }

    /**
     * 递增值
     *
     * @param key 键名
     * @return 递增后的值
     */
    public Long increment(String key) {
        Jedis jedis = getRedis();
        Long value = null;
        if (jedis.exists(key)) {
            value = jedis.incr(key);
        }
        release(jedis);
        return value;
    }

    /**
     * 删除键
     *
     * @param key 键名
     */
    public void delete(String key) {
        if (isNull(key)) {
            return;
        }
        if (exists(key)) {
            Jedis jedis = getRedis();
            jedis.del(key);
            release(jedis);
        }
    }

    /**
     * 判断键是否存在
     *
     * @param key 键名
     * @return 存在否
     */
    public Boolean exists(String key) {
        if (isNull(key)) {
            return false;
        }
        Jedis jedis = getRedis();
        Boolean boo = jedis.exists(key);
        release(jedis);
        return boo;
    }

    /**
     * 校验键值都不能为空
     *
     * @param key   键名
     * @param value 值
     * @return 都不为空 false; 任一为空 true.
     */
    private static boolean hasNull(String key, Object value) {
        boolean keyIsNull = isNull(key);
        boolean valueIsNull = isNull(value);
        if (keyIsNull) {
            LOGGER.error("Key cannot be null");
        }
        if (valueIsNull) {
            LOGGER.error("Value cannot be null");
        }
        return keyIsNull || valueIsNull;
    }

    /**
     * 校验对象不能为空
     *
     * @param object 对象不能为空
     * @return null 返回 true; not null 返回 false.
     */
    private static boolean isNull(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            String str = object.toString().trim();
            int len = str.length();
            if (len == 0) {
                return true;
            }
            for (int i = 0; i < len; i++) {
                // 如果有一个字符不为空就return不为空true
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 加锁
     *
     * @param key         锁名称
     * @param waitTimeout 获取锁的等待时间
     * @param lockTimeout 设置锁的有效时间
     * @return 设置锁是否成功
     */
    public String getLockWithWait(String key, long waitTimeout, long lockTimeout) {
        Jedis jedis = null;
        try {
            jedis = getRedis();
            // 随机生成一个value
            String uuid = UUID.randomUUID().toString();
            // 获取锁等待时间, 超过此时间则放弃获取锁
            long timeWait = System.currentTimeMillis() + waitTimeout;
            // 加锁后超时时间, 超过此时间则自动释放锁
            int lockSeconds = (int) (lockTimeout / 1000);
            // 当前时间小于等待时间
            while (System.currentTimeMillis() < timeWait) {
                // 获取锁, 当且仅当 key 不存在
                if (1 == jedis.setnx(key, uuid)) {
                    jedis.expire(key, lockSeconds);
                    return uuid;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    LOGGER.error(key + "获取锁异常", e);
                }
            }
            return null;
        } catch (Exception e) {
            LOGGER.error(key + "获取锁异常", e);
            return null;
        } finally {
            release(jedis);
        }
    }

    /**
     * 注意下边连接的三步的顺序
     * 一、host 以及端口
     * 二、设置连接密码
     * 三、设置连接的第几个Redis数据库
     */
    public static void main(String[] args) {
        Jedis jedis = new Jedis("112.74.57.49", 6379);
        jedis.auth("root");
        jedis.select(10);
        jedis.del("666");
        jedis.getSet("666", "123456");
    }
}
