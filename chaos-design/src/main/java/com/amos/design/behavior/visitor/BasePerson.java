package com.amos.design.behavior.visitor;

/**
 * DESCRIPTION: Person
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public abstract class BasePerson {

    /**
     * 执行
     *
     * @param visitor BaseVisitor
     */
    public abstract void execute(BaseVisitor visitor);

}
