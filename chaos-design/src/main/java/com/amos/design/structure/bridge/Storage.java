package com.amos.design.structure.bridge;

/**
 * DESCRIPTION: 存储
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
public interface Storage {

    /**
     * 存储信息
     *
     * @return info
     */
    String storageInfo();


    /**
     * 64G
     */
    class Storage64G implements Storage {
        @Override
        public String storageInfo() {
            return this.getClass().getSimpleName().replace(
                    this.getClass().getInterfaces()[0].getSimpleName(), ""
            );
        }
    }

    /**
     * 128G
     */
    class Storage128G implements Storage {
        @Override
        public String storageInfo() {
            return this.getClass().getSimpleName().replace(
                    this.getClass().getInterfaces()[0].getSimpleName(), ""
            );
        }
    }


    /**
     * 256G
     */
    class Storage256G implements Storage {
        @Override
        public String storageInfo() {
            return this.getClass().getSimpleName().replace(
                    this.getClass().getInterfaces()[0].getSimpleName(), ""
            );
        }
    }

}
