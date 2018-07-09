package cn.amos.mode.design.factory2method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
public class FactoryB implements IFactory {

    @Override
    public IProduct getInstance() {
        return new ProductB();
    }
}
