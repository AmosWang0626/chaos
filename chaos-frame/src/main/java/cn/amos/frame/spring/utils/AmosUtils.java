package cn.amos.frame.spring.utils;

import cn.amos.common.utils.base.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DESCRIPTION: AmosUtils
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class AmosUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmosUtils.class);

    public static void println(Object msg) {
        LOGGER.info(">>>>> " + msg.toString());
    }

    public static void println(Object msg, Integer deep) {
        LOGGER.info(">>>>> " + StringUtils.repeat("\t", deep) + msg.toString());
    }

}
