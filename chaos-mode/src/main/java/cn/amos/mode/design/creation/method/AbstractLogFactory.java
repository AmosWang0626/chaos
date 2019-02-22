package cn.amos.mode.design.creation.method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
abstract class AbstractLogFactory {

    /**
     * 获取真实产品类
     *
     * @return 产品类
     */
    abstract AbstractRealLog getInstance();

}
