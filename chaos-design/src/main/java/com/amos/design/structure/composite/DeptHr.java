package com.amos.design.structure.composite;

import cn.amos.common.utils.base.StringUtils;

/**
 * DESCRIPTION: 人力资源部
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public class DeptHr extends BaseCompany {

    public DeptHr(String name) {
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
        System.out.printf("%s 员工招聘人事管理\n", getName());
    }
}
