package cn.amos.mode.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/16
 */
public class Manage implements InterNotify {

    private List<InterNotify> persons = new ArrayList<>();

    public void addPerson(InterNotify person) {
        persons.add(person);
    }

    @Override
    public void notifyMsg(String msg) {
        for (InterNotify person : persons) {
            person.notifyMsg(msg);
        }
    }
}
