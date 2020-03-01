package com.amos.design.behavior.visitor.company;

/**
 * DESCRIPTION: CEO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public class CeoVisitor extends BaseCompanyVisitor {

    @Override
    public void developer(CompanyPersonDeveloper person) {
        System.out.println(this.getClass().getSimpleName() + " 我要看KPI");
        System.out.println("\t\t\tKPI:" + person.kpi() + ", By:" + person.getName());
    }

    @Override
    public void manager(CompanyPersonManager person) {
        System.out.println(this.getClass().getSimpleName() + " 我要看KPI和参与产品数量");
        System.out.println("\t\t\tKPI:" + person.kpi() + ", Products:" + person.products() + ", By:" + person.getName());
    }

}
