package com.amos.design.behavior.visitor;

/**
 * DESCRIPTION: Base访问者
 * [适合数据结构明确且有限的抽象。例如，男人、女人；黑、白；上、中、下]
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public abstract class BaseVisitor {
    /**
     * 男人
     */
    public abstract void man();

    /**
     * 女人
     */
    public abstract void woman();
}
