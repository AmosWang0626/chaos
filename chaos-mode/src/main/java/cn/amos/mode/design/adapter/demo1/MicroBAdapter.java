package cn.amos.mode.design.adapter.demo1;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/6
 */
public class MicroBAdapter implements USB {

    @Override
    public void charge() {
        new MicroB().mbCharge();
    }
}
