package cn.amos.design.factory2method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
public interface IFactory {

    /**
     * 获取真实产品类
     *
     * @return 产品类
     */
    IProduct getInstance();
}
