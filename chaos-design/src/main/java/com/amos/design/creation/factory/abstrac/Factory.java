package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public abstract class Factory {

    /**
     * 用户相关
     *
     * @return User
     */
    abstract User createUser();

    /**
     * 数据管理相关
     *
     * @return Manage
     */
    abstract Manage dataManage();

}
