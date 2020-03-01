package com.amos.design.behavior.visitor.company;

import lombok.Getter;

/**
 * DESCRIPTION: 研发人员、产品经理
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
@Getter
public abstract class BaseCompanyPerson {

    private String name;

    public BaseCompanyPerson(String name) {
        this.name = name;
    }

    /**
     * 绩效
     *
     * @return KPI
     */
    public abstract Integer kpi();

    /**
     * 总览
     *
     * @param visitor 访问者
     */
    public abstract void visit(BaseCompanyVisitor visitor);

}
