package cn.amos.mode.design.creation.abstractt;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/2/22
 */
public class UserMySQL extends User {

    @Override
    String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    String getPermission() {
        return "增删改查索引";
    }
}
