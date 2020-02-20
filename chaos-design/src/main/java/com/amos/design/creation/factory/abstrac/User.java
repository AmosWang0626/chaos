package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public abstract class User {

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    abstract String getName();

    /**
     * 获取用户权限
     *
     * @return 用户权限
     */
    abstract String getPermission();

}
