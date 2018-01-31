package cn.amos.simple;

import cn.amos.frame.redis.RedisUnity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ComponentScan("cn.amos")
@SpringBootTest(classes = ChaosApplicationTests.class)
public class ChaosApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChaosApplicationTests.class);

    @Resource
    private RedisUnity redisUnity;

    @Test
    public void testRedis() {
        Boolean exists = redisUnity.exists("user");
        LOGGER.info("key user is exist ? [{}]", exists);
        String user = redisUnity.get("user");
        LOGGER.info("key user value is : [{}]", user);
        redisUnity.set("user", null);
    }
}
