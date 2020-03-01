package com.amos.design.behavior.visitor.person;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION: Person[]
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public class PersonStruct {

    private List<BasePerson> list = new ArrayList<>();

    public void add(BasePerson person) {
        this.list.add(person);
    }

    public void delete(BasePerson person) {
        this.list.remove(person);
    }

    public void execute(BaseVisitor visitor) {
        list.forEach(person -> person.execute(visitor));
    }

}
