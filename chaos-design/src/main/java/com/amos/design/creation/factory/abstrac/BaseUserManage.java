package com.amos.design.creation.factory.abstrac;

/**
 * DESCRIPTION: 用户管理
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/29/2020
 */
public abstract class BaseUserManage {
    /**
     * 新增用户
     *
     * @param name 用户名
     * @return 成功条数
     */
    abstract Integer addUser(String name);

    /**
     * 删除用户
     *
     * @param name 用户名
     * @return 成功条数
     */
    abstract Integer delUser(String name);
}