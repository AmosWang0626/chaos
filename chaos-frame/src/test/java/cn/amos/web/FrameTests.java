package cn.amos.web;

import cn.amos.frame.redis.stastic.SimpleRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Slf4j
@RunWith(SpringRunner.class)
@ComponentScan("cn.amos")
@SpringBootTest(classes = FrameTests.class)
public class FrameTests {

    /*
    @Resource
    private SimpleRedisUtil redisUtil;

    @Test
    public void testRedis() {
        Boolean exists = redisUtil.exists("user");
        LOGGER.info("key user is exist ? [{}]", exists);
        String user = redisUtil.get("user");
        LOGGER.info("key user value is : [{}]", user);
        redisUtil.set("user", null);
    }*/

    @Test
    public void list() {
        int dbIndex = 12;
        String key = "hello";

        SimpleRedisUtil.del(key, dbIndex);
        Long count = SimpleRedisUtil.lpush(key, dbIndex, "111", "222", "333", "444", "555");
        log.info("-------> count is " + count);
        count = SimpleRedisUtil.lpush(key, dbIndex, "666");
        log.info("-------> count is " + count);

        // （-1L,-1L） 取的是第一个插入列表的数据
        List<String> list = SimpleRedisUtil.lchange(key, dbIndex, -1L, -1L);
        log.info("list index[-1,-1] is " + list.toString());

        // 同理,（0,0）取得是最后一个插入列表的数据
        list = SimpleRedisUtil.lchange(key, dbIndex, 0, 0);
        log.info("list index[0,0] is " + list.toString());
    }

    @Test
    public void hash() {
        int dbIndex = 12;
        String key = "hello";

        SimpleRedisUtil.del(key, dbIndex);

        Map<String, String> map = new TreeMap<>();
        map.put("111", "1");
        map.put("222", "11");
        map.put("333", "111");
        map.put("444", "1111");
        map.put("555", "11111");

        log.info("tree map is " + map.toString());

        // 无序的,无论传入的map是否有序
        SimpleRedisUtil.hmset(key, map, dbIndex);

        String value = SimpleRedisUtil.hget(key, "111", dbIndex);
        log.info("-------> key = 111, value is " + value);
    }

    @Test
    public void set() {
        int dbIndex = 12;
        String key = "hello";

        SimpleRedisUtil.del(key, dbIndex);

        SimpleRedisUtil.sadd(key, dbIndex, "111", "222", "333");

        Set<String> values = SimpleRedisUtil.smembers(key, dbIndex);
        log.info("-------> key = hello, values is " + values);
    }

    @Test
    public void sort() {
        int dbIndex = 12;
        String key = "hello";

        SimpleRedisUtil.del(key, dbIndex);
        Map<String, Double> map = new TreeMap<>();
        map.put("111", 1D);
        map.put("222", 2D);
        map.put("333", 3D);
        map.put("444", 4D);
        map.put("555", 5D);

        SimpleRedisUtil.zadd(key, map, dbIndex);

        Set<String> values = SimpleRedisUtil.zrange(key, dbIndex, 0, 2);
        log.info("-------> index(0,2), values is " + values);
    }

}
