package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: 用户管理
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class UserOperates {

    public static class MySqlUser extends BaseUserManage {
        @Override
        public Integer addUser(String name) {
            System.out.println("MySQL 新增用户 " + name);
            return 1;
        }

        @Override
        public Integer delUser(String name) {
            System.out.println("MySQL 删除用户 " + name);
            return 1;
        }
    }

    public static class OracleUser extends BaseUserManage {
        @Override
        public Integer addUser(String name) {
            System.out.println("MySQL 新增用户 " + name);
            return 1;
        }

        @Override
        public Integer delUser(String name) {
            System.out.println("MySQL 删除用户 " + name);
            return 1;
        }
    }

}
