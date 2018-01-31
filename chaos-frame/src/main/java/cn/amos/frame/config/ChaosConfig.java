package cn.amos.frame.config;

import cn.amos.frame.redis.RedisContainer;
import cn.amos.frame.redis.RedisUnity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PROJECT: chaos
 *
 * @author DaoYuanWang
 * @apiNote 本项目配置文件
 * @date 2018/1/31
 */
@Configuration
public class ChaosConfig {
    @Bean
    public RedisUnity redisContainer(){
        return new RedisUnity(new RedisContainer("112.74.57.49", 6379, "root", 0));
    }
}
