package cn.amos.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTests {

    @Test
    public void testAopService() {
        System.out.println("hello world!");
    }

}
