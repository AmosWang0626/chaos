package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class Factory {

    public abstract static class BaseFactory {

        /**
         * 用户相关
         *
         * @return User
         */
        public abstract UserOperate.BaseUserDao createUser();

        /**
         * 数据管理相关
         *
         * @return Manage
         */
        public abstract LockOperate.LockDao dataManage();
    }

    public static class FactoryMySql extends BaseFactory {

        @Override
        public UserOperate.BaseUserDao createUser() {
            return new UserOperate.UserMySql();
        }

        @Override
        public LockOperate.LockDao dataManage() {
            return new LockOperate.MySqlLock();
        }
    }

    public static class FactoryOracle extends BaseFactory {

        @Override
        public UserOperate.BaseUserDao createUser() {
            return new UserOperate.UserOracle();
        }

        @Override
        public LockOperate.LockDao dataManage() {
            return new LockOperate.OracleLock();
        }
    }

}
