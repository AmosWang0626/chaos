package com.amos.design.structure.bridge;

/**
 * DESCRIPTION: 手机's
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
public interface Phones {

    /**
     * MI
     */
    class MiPhone extends BasePhone {
        public MiPhone(Memory memory, Storage storage) {
            super(memory, storage);
        }

        @Override
        public String brand() {
            return "MI";
        }
    }

    /**
     * HUA WEI
     */
    class HuaWeiPhone extends BasePhone {
        public HuaWeiPhone(Memory memory, Storage storage) {
            super(memory, storage);
        }

        @Override
        public String brand() {
            return "HUA-WAI";
        }
    }

}
