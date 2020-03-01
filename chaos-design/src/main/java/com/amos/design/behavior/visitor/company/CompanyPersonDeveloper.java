package com.amos.design.behavior.visitor.company;

import java.util.Random;

/**
 * DESCRIPTION: 研发人员
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class CompanyPersonDeveloper extends BaseCompanyPerson {

    public CompanyPersonDeveloper(String name) {
        super(name);
    }

    @Override
    public Integer kpi() {
        return new Random().nextInt(10) + 20;
    }

    public Integer codeAmount() {
        return new Random().nextInt(10) + 100;
    }

    @Override
    public void visit(BaseCompanyVisitor visitor) {
        visitor.developer(this);
    }
}
