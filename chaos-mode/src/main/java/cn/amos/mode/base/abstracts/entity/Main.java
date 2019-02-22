package cn.amos.mode.base.abstracts.entity;

import java.util.Date;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类描述
 *
 * @author DaoyuanWang
 * @date 2018/7/5
 */
public class Main {

    public static void main(String[] args) {
        OrderEntity baseEntity = new OrderEntity();
        baseEntity.setCount(100);
        baseEntity.setCommodityCode("666");
        baseEntity.setCreateTime(new Date());
        System.out.println(baseEntity.getCommodityCode());
    }

}