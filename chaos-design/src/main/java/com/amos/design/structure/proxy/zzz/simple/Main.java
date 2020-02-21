package com.amos.design.structure.proxy.zzz.simple;

import com.amos.design.structure.proxy.zzz.simple.send.SendProxy;
import com.amos.design.structure.proxy.zzz.simple.send.SendReal;

/**
 * PROJECT: chaos
 * DESCRIPTION: 静态代理 --> 执行方法
 *
 * @author DaoYuanWang
 * @date 2018/7/6
 */
public class Main {

    public static void main(String[] args) {
        SendProxy sendProxy = new SendProxy(new SendReal());
        sendProxy.flower();
    }

}
