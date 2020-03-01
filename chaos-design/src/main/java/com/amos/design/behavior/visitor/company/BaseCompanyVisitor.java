package com.amos.design.behavior.visitor.company;

/**
 * DESCRIPTION: 访问者
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public abstract class BaseCompanyVisitor {

    /**
     * 研发
     *
     * @param person developer
     */
    public abstract void developer(CompanyPersonDeveloper person);

    /**
     * 产品经理
     *
     * @param person manager
     */
    public abstract void manager(CompanyPersonManager person);

}
