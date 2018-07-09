package cn.amos.mode.design.proxy;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sendFlower() {
        if (subject != null) {
            System.out.println("代理准备送花，");
            subject.sendFlower();
            System.out.println("代理送花完成。");
        }
    }
}
