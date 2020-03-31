package cn.amos.frame.redis;

import cn.amos.frame.redis.config.RedisConfig;
import cn.amos.frame.redis.service.SpikePhoneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * DESCRIPTION: RedisMain
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/3/31
 */
public class RedisMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(RedisConfig.class);
        SpikePhoneService spikePhoneService = context.getBean(SpikePhoneService.class);
        spikePhoneService.execute();
    }

}
