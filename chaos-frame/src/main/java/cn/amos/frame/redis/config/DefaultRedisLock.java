package cn.amos.frame.redis.config;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * DESCRIPTION: redis lock impl
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
@Service
public class DefaultRedisLock implements RedisLock {

    @Resource
    private JedisPool jedisPool;

    @Override
    public String lock(String key, int timeout, int expire) {
        try (Jedis client = jedisPool.getResource()) {
            String value = UUID.randomUUID().toString();
            long lastTime = System.currentTimeMillis() + timeout;
            while (System.currentTimeMillis() < lastTime) {
                if (client.setnx(key, value) == 1) {
                    if (client.ttl(key) == -1) {
                        client.expire(key, expire);
                    }
                    return value;
                }
            }
        }

        return null;
    }

    @Override
    public boolean unlock(String key, String value) {
        try (Jedis client = jedisPool.getResource()) {
            while (client.exists(key)) {
                client.watch(key);
                if (value.equals(client.get(key))) {
                    Transaction multi = client.multi();
                    multi.del(key);
                    List<Object> execQueue = multi.exec();
                    if (execQueue != null) {
                        return true;
                    }
                }
                break;
            }
            return false;
        }
    }

}
