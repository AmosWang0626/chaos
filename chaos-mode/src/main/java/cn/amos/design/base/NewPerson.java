package cn.amos.design.base;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/3
 */
public class NewPerson extends BasePerson implements ProgramSkill {

    @Override
    public String programming() {
        return this.name + " will program!";
    }

    public static void main(String[] args) {
        NewPerson newPerson = new NewPerson();
        newPerson.name = "Smith";
        System.out.println(newPerson.programming());
    }
}
