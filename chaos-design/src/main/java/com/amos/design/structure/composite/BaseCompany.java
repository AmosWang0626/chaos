package com.amos.design.structure.composite;

/**
 * DESCRIPTION: 公司
 * 注意：叶子节点是否含有 add 和 drop 又分为 透明方式(含有)和安全方式(不含)。
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public abstract class BaseCompany {

    private String name;

    public BaseCompany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 新增
     *
     * @param company 部门/分公司
     */
    abstract void add(BaseCompany company);

    /**
     * 删除
     *
     * @param company 部门/分公司
     */
    abstract void drop(BaseCompany company);

    /**
     * 显示
     *
     * @param level 层级
     */
    abstract void display(int level);

    /**
     * 职责范围
     */
    abstract void lineOfDuty();
}
