package com.amos.design.structure.proxy.zzz.simple.send;

/**
 * PROJECT: chaos
 * DESCRIPTION: 真实要送花人
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class SendReal implements Send {

    @Override
    public void flower() {
        System.out.println("\t真实送花人要送一枝玫瑰花");
    }
}
