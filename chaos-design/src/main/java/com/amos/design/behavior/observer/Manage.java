package com.amos.design.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/16
 */
public class Manage implements Notify {

    private List<Notify> persons = new ArrayList<>();

    public void addPerson(Notify person) {
        persons.add(person);
    }

    @Override
    public void notifyMsg(String msg) {
        for (Notify person : persons) {
            person.notifyMsg(msg);
        }
    }

}
