package cn.amos.design.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class HelloContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloContext.class);

    private AbstractHello abstractHello;

    public HelloContext(AbstractHello abstractHello) {
        this.abstractHello = abstractHello;
    }

    public void contextInterface() {
        LOGGER.info(abstractHello.sayHello());
    }
}
