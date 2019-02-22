package cn.amos.mode.design.creation.method;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/7
 */
public class RealLogDatabase extends AbstractRealLog {

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void writeLog(String log) {
        System.out.println(this.getClass().getSimpleName() + " write log >>>>>: " + log);
    }
}
