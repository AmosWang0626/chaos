package com.amos.design.behavior.chain;

/**
 * DESCRIPTION: Log Utils
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/20/2020
 */
public class Developers {

    /**
     * [低] 软件研发实习生
     */
    public static class DeveloperOne extends BaseDeveloper {
        public DeveloperOne() {
            this.level = BaseDeveloper.HardLevel.ONE;
        }

        @Override
        public void realDevelop(String demand) {
            System.out.println("软件研发实习生 >>>>>>>>>> " + demand);
        }
    }

    /**
     * [中] 初级研发工程师
     */
    public static class DeveloperTwo extends BaseDeveloper {
        public DeveloperTwo() {
            this.level = BaseDeveloper.HardLevel.TWO;
        }

        @Override
        public void realDevelop(String demand) {
            System.out.println("初级研发工程师 >>>>>>>>>> " + demand);
        }
    }

    /**
     * [高] 高级研发工程师
     */
    public static class DeveloperThree extends BaseDeveloper {
        public DeveloperThree() {
            this.level = BaseDeveloper.HardLevel.THREE;
        }

        @Override
        public void realDevelop(String demand) {
            System.out.println("高级研发工程师 >>>>>>>>>> " + demand);
        }
    }

}
