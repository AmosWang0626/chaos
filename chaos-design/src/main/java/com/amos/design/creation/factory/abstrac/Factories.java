package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: Factories
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class Factories {

    public static class FactoryMySql extends BaseFactory {
        @Override
        public BaseUserManage userManage() {
            return new UserOperates.MySqlUser();
        }

        @Override
        public BaseDataManage dataManage() {
            return new DataOperates.MySqlData();
        }
    }

    public static class FactoryOracle extends BaseFactory {
        @Override
        public BaseUserManage userManage() {
            return new UserOperates.OracleUser();
        }

        @Override
        public BaseDataManage dataManage() {
            return new DataOperates.OracleData();
        }
    }

}
