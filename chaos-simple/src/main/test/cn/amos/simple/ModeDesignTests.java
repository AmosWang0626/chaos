package cn.amos.simple;

import cn.amos.design.factory.Operation;
import cn.amos.design.factory.OperationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ComponentScan("cn.amos")
@SpringBootTest(classes = ModeDesignTests.class)
public class ModeDesignTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModeDesignTests.class);

    @Test
    public void testFactory() {
        Operation operate = OperationFactory.createOperate("*");
        if (operate == null) {
            LOGGER.info("运算类型不存在!");
            return;
        }

        operate.setNum1(100);
        operate.setNum2(100);

        LOGGER.info("result: " + operate.getResult());
    }
}
