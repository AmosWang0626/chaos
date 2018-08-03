package cn.amos.mode.design.proxy.cglib;

import cn.amos.mode.design.proxy.cglib.trans.TransMotorcycle;
import cn.amos.mode.design.proxy.cglib.trans.TransSportsCar;

/**
 * NOTE: 利用 Cglib 实现的动态代理 --> 执行方法
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class Main {

    public static void main(String[] args) {
        TransSportsCar transSportsCar = (TransSportsCar) new CglibProxy().getProxy(TransSportsCar.class);
        transSportsCar.start();
        System.out.println("\n=============hua li li de fen ge fu==================\n");
        TransMotorcycle transMotorcycle = (TransMotorcycle) new CglibProxy().getProxy(TransMotorcycle.class);
        transMotorcycle.start();
    }
}
