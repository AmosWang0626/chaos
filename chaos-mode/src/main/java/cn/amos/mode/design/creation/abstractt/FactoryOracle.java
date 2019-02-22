package cn.amos.mode.design.creation.abstractt;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class FactoryOracle extends Factory {

    @Override
    User createUser() {
        return new UserOracle();
    }

    @Override
    Manage dataManage() {
        return new ManageOracle();
    }
}
