package cn.amos.mode.design.proxy.simple;

/**
 * PROJECT: chaos
 * DESCRIPTION: 代理真实送花人
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class ProxyPerson implements Subject {

    private Subject subject;

    public ProxyPerson(Subject subject) {
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
