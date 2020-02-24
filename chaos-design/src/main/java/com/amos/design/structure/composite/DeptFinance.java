package com.amos.design.structure.composite;

import cn.amos.common.utils.base.StringUtils;

/**
 * DESCRIPTION: 财务部门
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public class DeptFinance extends BaseCompany {

    public DeptFinance(String name) {
        super(name);
    }

    @Override
    public void add(BaseCompany company) {

    }

    @Override
    public void drop(BaseCompany company) {

    }

    @Override
    public void display(int level) {
        System.out.println(StringUtils.repeat("-", level) + getName());
    }

    @Override
    public void lineOfDuty() {
        System.out.printf("%s 公司财务收支管理\n", getName());
    }
}
