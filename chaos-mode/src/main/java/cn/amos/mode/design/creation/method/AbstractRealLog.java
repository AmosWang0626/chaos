package cn.amos.mode.design.creation.method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
abstract class AbstractRealLog {

    /**
     * 获取产品名称
     *
     * @return 产品名称
     */
    abstract String name();

    /**
     * 写日志
     *
     * @param log 日志
     */
    abstract void writeLog(String log);
}
