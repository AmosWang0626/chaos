package cn.amos.web;

import cn.amos.frame.aop.TestAopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/9
 */
@RunWith(SpringRunner.class)
@ComponentScan("cn.amos.frame.aop")
@SpringBootTest(classes = FrameTests.class)
public class AopTests {

    @Resource
    private TestAopService testAopService;

    @Test
    public void testAopService() {
        testAopService.hello("AAA");
        testAopService.hello("BBB");
        testAopService.hello("CCC");
    }
}
