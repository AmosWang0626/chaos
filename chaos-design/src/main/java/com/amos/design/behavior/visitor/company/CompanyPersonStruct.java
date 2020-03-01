package com.amos.design.behavior.visitor.company;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION: CompanyPersonStruct
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class CompanyPersonStruct {

    private List<BaseCompanyPerson> personList = new ArrayList<>();

    public void addPerson(BaseCompanyPerson person) {
        this.personList.add(person);
    }

    public void range(BaseCompanyVisitor visitor) {
        personList.forEach(person -> {
            person.visit(visitor);
        });
    }
}
