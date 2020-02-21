package com.amos.design.structure.proxy.zzz.cglib.trans;

/**
 * NOTE: 劳斯莱斯 come on
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class TransRollsRoyce implements Trans {

    @Override
    public void start(String name, String target) {
        System.out.println("------------Rolls Royce----------------");
        System.out.println(name + " 检查车身, 检查油量, 系好安全带!");
        System.out.println("启动跑车, 挂挡, 踩油门, 向" + target + "出发......");
        System.out.println("------------Rolls Royce----------------");
    }
}
