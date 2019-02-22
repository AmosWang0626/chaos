package cn.amos.mode.design.creation.method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
public class LogFactoryDatabase extends AbstractLogFactory {

    @Override
    public AbstractRealLog getInstance() {
        return new RealLogDatabase();
    }
}
