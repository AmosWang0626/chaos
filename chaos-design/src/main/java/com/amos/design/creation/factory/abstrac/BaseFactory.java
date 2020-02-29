package com.amos.design.creation.factory.abstrac;

/**
 * DESCRIPTION: Base工厂类（用户管理、数据管理）
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/29/2020
 */
public abstract class BaseFactory {

    /**
     * 用户管理
     *
     * @return User
     */
    public abstract BaseUserManage userManage();

    /**
     * 数据管理
     *
     * @return Manage
     */
    public abstract BaseDataManage dataManage();
}