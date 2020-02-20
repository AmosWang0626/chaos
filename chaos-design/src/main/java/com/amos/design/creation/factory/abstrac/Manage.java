package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public abstract class Manage {

    /**
     * 加锁
     */
    abstract void lock();

    /**
     * 释放锁
     */
    abstract void unLock();

}
