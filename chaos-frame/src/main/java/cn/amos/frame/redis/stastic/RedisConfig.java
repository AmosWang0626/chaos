package cn.amos.frame.redis.stastic;

import lombok.Data;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * PROJECT: hello <br>
 * DESCRIPTION: notes
 *
 * @author wangdaoyuan
 * @date 2018/8/30
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    private String host;

    private String password;

    @Bean("jedisPool")
    public JedisPool jedisPool() {
        JedisPool jedisPool = new JedisPool(
                new GenericObjectPoolConfig(),
                host, 6379, 2000, password);

        RedisUtil.setJedisPool(jedisPool);

        return jedisPool;
    }
}
