package com.amos.design.structure.proxy.zzz.simple.send;

/**
 * PROJECT: chaos
 * DESCRIPTION: 代理真实送花人
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class SendProxy implements Send {

    private Send send;

    public SendProxy(Send send) {
        this.send = send;
    }

    @Override
    public void flower() {
        if (send != null) {
            System.out.println("代理准备送花，");
            send.flower();
            System.out.println("代理送花完成。");
        }
    }
}
