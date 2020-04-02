package cn.amos.frame.redis.config;

/**
 * DESCRIPTION: RedisLock interface
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
public interface RedisLock {

    /**
     * 初始化锁 (防止遗留锁未释放, 影响效果)
     *
     * @param key key
     */
    void init(String key);

    /**
     * 获取锁
     *
     * @param key     key
     * @param timeout 获取锁等待时间
     * @param expire  锁过期时间
     * @return value
     */
    String lock(String key, int timeout, int expire);

    /**
     * 释放锁（仅在 key/value 匹配时才让释放）
     *
     * @param key   key
     * @param value value
     */
    void unlock(String key, String value);

}
