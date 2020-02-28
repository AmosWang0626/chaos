package com.amos.design.behavior.visitor;

/**
 * DESCRIPTION: Persons
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public interface Persons {

    class Man extends BasePerson {
        @Override
        public void execute(BaseVisitor visitor) {
            visitor.man();
        }
    }

    class Woman extends BasePerson {
        @Override
        public void execute(BaseVisitor visitor) {
            visitor.woman();
        }
    }

}
