package cn.amos.web;

import cn.amos.frame.redis.RedisUtil;
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
@SpringBootTest(classes = FrameTests.class)
public class FrameTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrameTests.class);

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void testRedis() {
        Boolean exists = redisUtil.exists("user");
        LOGGER.info("key user is exist ? [{}]", exists);
        String user = redisUtil.get("user");
        LOGGER.info("key user value is : [{}]", user);
        redisUtil.set("user", null);
    }
}
