package com.amos.design.behavior.visitor.person;

/**
 * DESCRIPTION: Visitor 实现类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public interface Visitors {

    class VisitorSuccess extends BaseVisitor {
        @Override
        public void man() {
            /// 获取方法名
            // String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            System.out.println("男人成功时，背后多半有一个伟大的女人");
        }

        @Override
        public void woman() {
            System.out.println("女人成功时，背后大多有一个不成功的男人");
        }
    }

    class VisitorLove extends BaseVisitor {
        @Override
        public void man() {
            System.out.println("男人恋爱时，凡事不懂也要装懂");
        }

        @Override
        public void woman() {
            System.out.println("女人恋爱时，遇事懂也装作不懂");
        }
    }


}
