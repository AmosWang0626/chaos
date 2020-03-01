package com.amos.design.behavior.visitor.company;

import java.util.Random;

/**
 * DESCRIPTION: 产品经理
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class CompanyPersonManager extends BaseCompanyPerson {

    public CompanyPersonManager(String name) {
        super(name);
    }

    @Override
    public Integer kpi() {
        return new Random().nextInt(10) + 10;
    }

    public Integer products() {
        return new Random().nextInt(10) + 1;
    }

    @Override
    public void visit(BaseCompanyVisitor visitor) {
        visitor.manager(this);
    }

}
