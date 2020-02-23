package com.amos.design.structure.bridge;

/**
 * DESCRIPTION: 内存
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
public interface Memory {

    /**
     * 内存信息
     *
     * @return info
     */
    String memoryInfo();


    /**
     * 8G
     */
    class Memory8G implements Memory {
        @Override
        public String memoryInfo() {
            return this.getClass().getSimpleName().replace(
                    this.getClass().getInterfaces()[0].getSimpleName(), ""
            );
        }
    }

    /**
     * 16G
     */
    class Memory16G implements Memory {
        @Override
        public String memoryInfo() {
            return this.getClass().getSimpleName().replace(
                    this.getClass().getInterfaces()[0].getSimpleName(), ""
            );
        }
    }

}
