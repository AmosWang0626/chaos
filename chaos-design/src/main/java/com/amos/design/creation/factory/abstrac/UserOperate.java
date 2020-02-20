package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class UserOperate {

    public static abstract class BaseUserDao {
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

    public static class UserMySql extends BaseUserDao {

        @Override
        String getName() {
            return this.getClass().getSimpleName();
        }

        @Override
        String getPermission() {
            return "增删改查索引,旧版本不支持存储过程";
        }
    }

    public static class UserOracle extends BaseUserDao {

        @Override
        String getName() {
            return this.getClass().getSimpleName();
        }

        @Override
        String getPermission() {
            return "增删改查索引,支持存储过程";
        }
    }


}
