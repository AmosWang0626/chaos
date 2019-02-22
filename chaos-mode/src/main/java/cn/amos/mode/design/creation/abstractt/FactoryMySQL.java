package cn.amos.mode.design.creation.abstractt;

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
