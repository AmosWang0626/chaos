package com.amos.design.structure.proxy.zzz.cglib;

import com.amos.design.structure.proxy.zzz.cglib.trans.TransHarleyDavidson;
import com.amos.design.structure.proxy.zzz.cglib.trans.TransRollsRoyce;

/**
 * NOTE: 利用 Cglib 实现的动态代理 --> 执行方法
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class Main {

    public static void main(String[] args) {
        TransRollsRoyce transRollsRoyce = (TransRollsRoyce) new CglibProxy().getProxy(TransRollsRoyce.class);
        transRollsRoyce.start("Grace", "洛阳");
        System.out.println("\n=============hua li li de fen ge fu==================\n");
        TransHarleyDavidson transHarleyDavidson = (TransHarleyDavidson) new CglibProxy().getProxy(TransHarleyDavidson.class);
        transHarleyDavidson.start("Amos", "邓州");
    }
}
