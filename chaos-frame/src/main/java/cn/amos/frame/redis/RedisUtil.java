package cn.amos.frame.redis;

/**
 * @author DaoyuanWang
 * @apiNote Redis 工具类
 * @date 2018/1/31
 */
public class RedisUtil {

    /**
     * Redis 容器
     */
    private BaseRedisUtil baseRedisUtil;

    public RedisUtil(BaseRedisUtil baseRedisUtil) {
        this.baseRedisUtil = baseRedisUtil;
    }

    /**
     * 添加键值
     *
     * @param key   键名
     * @param value 值 Object
     */
    public void set(String key, Object value) {
        baseRedisUtil.set(key, value);
    }

    /**
     * 添加键值，包含时间
     *
     * @param key   键名
     * @param value 值
     * @param time  时间
     */
    public void set(String key, String value, int time) {
        baseRedisUtil.set(key, value, time);
    }

    /**
     * 根据键获得值
     *
     * @param key 键名
     * @return 值
     */
    public String get(String key) {
        return baseRedisUtil.get(key);
    }

    /**
     * 获得旧值设置新值
     *
     * @param key   键名
     * @param value 新值
     * @return 旧值
     */
    public String getSet(String key, String value) {
        return baseRedisUtil.getSet(key, value);
    }

    /**
     * 设置新的key保存时间
     *
     * @param key  键名
     * @param time 时间
     */
    public void setNewTime(String key, int time) {
        baseRedisUtil.setNewTime(key, time);
    }

    /**
     * 递增值
     *
     * @param key 键名
     * @return 递增后的值
     */
    public Long increment(String key) {
        return baseRedisUtil.increment(key);
    }

    /**
     * 删除键
     *
     * @param key 键名
     */
    public void delete(String key) {
        baseRedisUtil.delete(key);
    }

    /**
     * 判断键是否存在
     *
     * @param key 键名
     * @return 存在否
     */
    public Boolean exists(String key) {
        return baseRedisUtil.exists(key);
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
        return baseRedisUtil.getLockWithWait(key, waitTimeout, lockTimeout);
    }
}
