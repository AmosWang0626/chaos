package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class ManageMySQL extends Manage {

    @Override
    void lock() {
        System.out.println(this.getClass().getSimpleName() + " 开始加锁处理...");
    }

    @Override
    void unLock() {
        System.out.println(this.getClass().getSimpleName() + " 处理完成，解锁成功！");
    }
}
