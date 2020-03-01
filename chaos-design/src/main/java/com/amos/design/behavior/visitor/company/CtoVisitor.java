package com.amos.design.behavior.visitor.company;

/**
 * DESCRIPTION: CTO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class CtoVisitor extends BaseCompanyVisitor {

    @Override
    public void developer(CompanyPersonDeveloper person) {
        System.out.println(this.getClass().getSimpleName() + " 我要看代码量");
        System.out.println("\t\t\tCode Amount:" + person.codeAmount() + ", By:" + person.getName());
    }

    @Override
    public void manager(CompanyPersonManager person) {
        System.out.println(this.getClass().getSimpleName() + " 我要看参与产品数量");
        System.out.println("\t\t\tProducts:" + person.products() + ", By:" + person.getName());
    }

}
