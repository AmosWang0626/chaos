package cn.amos.design.strategy;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
public class HelloContextFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloContextFactory.class);

    private AbstractHello abstractHello;

    public HelloContextFactory(String country) {
        if (StringUtils.isBlank(country)) {
            LOGGER.info("国家不能为null");
        }

        switch (country) {
            case "china":
                abstractHello = new ChineseHello();
                break;

            case "english":
                abstractHello = new EnglishHello();
                break;

            default:
                break;
        }
    }

    public void contextInterface() {
        LOGGER.info(abstractHello.sayHello());
    }
}
