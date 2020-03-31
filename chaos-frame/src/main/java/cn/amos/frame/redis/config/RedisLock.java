package cn.amos.frame.redis.config;

/**
 * DESCRIPTION: RedisLock interface
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
public interface RedisLock {

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
     * @return true 释放成功
     */
    boolean unlock(String key, String value);

}
