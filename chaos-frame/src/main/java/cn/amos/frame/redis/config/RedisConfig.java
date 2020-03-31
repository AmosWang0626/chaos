package cn.amos.frame.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * DESCRIPTION: RedisConfig
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
@Configuration
@ComponentScan("cn.amos.frame.redis")
public class RedisConfig {

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(5);
        poolConfig.setMaxTotal(5000);
        return new JedisPool(poolConfig, "127.0.0.1", 6379);
    }

    /// @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> clusters = new HashSet<>();
        clusters.add(new HostAndPort("127.0.0.1", 6379));
        clusters.add(new HostAndPort("127.0.0.1", 6380));
        clusters.add(new HostAndPort("127.0.0.1", 6381));
        return new JedisCluster(clusters);
    }


}
