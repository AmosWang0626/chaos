package com.amos.design.structure.proxy.zzz.cglib.trans;

/**
 * NOTE: 哈雷 吼吼
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class TransHarleyDavidson implements Trans {

    @Override
    public void start(String name, String target) {
        System.out.println("------------core----------------");
        System.out.println(name + " 检查车身, 检查油量, 带上头盔!");
        System.out.println("启动摩托, 挂挡, 拧油门, 向" + target + "出发......");
        System.out.println("------------core----------------");
    }
}
