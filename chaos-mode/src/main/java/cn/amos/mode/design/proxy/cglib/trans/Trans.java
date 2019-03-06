package cn.amos.mode.design.proxy.cglib.trans;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public interface Trans {

    /**
     * 启动...
     *
     * @param name   驾驶员名字
     * @param target 目的地
     */
    void start(String name, String target);
}
