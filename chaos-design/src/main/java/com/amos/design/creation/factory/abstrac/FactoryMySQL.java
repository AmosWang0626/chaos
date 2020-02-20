package com.amos.design.creation.factory.abstrac;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class FactoryMySQL extends Factory {

    @Override
    User createUser() {
        return new UserMySQL();
    }

    @Override
    Manage dataManage() {
        return new ManageMySQL();
    }
}
