package com.amos.design.structure.composite;

import cn.amos.common.utils.base.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION: 具体公司
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public class ConcreteCompany extends BaseCompany {

    private Map<String, BaseCompany> map = new HashMap<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    void add(BaseCompany company) {
        map.put(company.getName(), company);
    }

    @Override
    void drop(BaseCompany company) {
        map.remove(company.getName());
    }

    @Override
    void display(int level) {
        System.out.println(StringUtils.repeat("-", level) + getName());
        map.values().forEach(company -> company.display(level + 2));
    }

    @Override
    void lineOfDuty() {
        map.values().forEach(BaseCompany::lineOfDuty);
    }
}
