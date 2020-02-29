package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: 数据管理
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class DataOperates {

    public static class MySqlData extends BaseDataManage {
        @Override
        public void saveData() {
            System.out.println(this.getClass().getSimpleName() + " MySQL 新增数据...");
        }

        @Override
        public void getData() {
            System.out.println(this.getClass().getSimpleName() + " MySQL 获取数据！");
        }
    }

    public static class OracleData extends BaseDataManage {
        @Override
        public void saveData() {
            System.out.println(this.getClass().getSimpleName() + " Oracle 新增数据...");
        }

        @Override
        public void getData() {
            System.out.println(this.getClass().getSimpleName() + " Oracle 获取数据！");
        }
    }

}
