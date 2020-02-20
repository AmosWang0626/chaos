package com.amos.design.structure.adapter;

/**
 * DESCRIPTION: 适配器模式核心代码
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/20/2020
 */
public class AdapterCore {

    public static class MicroUsb {
        public String microCharge() {
            return "Micro-USB 充电";
        }

        public String microTrans() {
            return "Micro-USB 传输数据";
        }
    }

    public static class TypeC {
        public String typeCharge() {
            return "USB Type-C 充电";
        }

        public String typeTrans() {
            return "USB Type-C 传输数据";
        }
    }

    /**
     * USB接口，构建两个适配器
     * 通过适配器，无代码侵入地使用 Micro-USB 和 Type-C
     */
    public interface Usb {
        /**
         * 作用 1 充电
         */
        void charge();

        /**
         * 作用 2 传输数据
         */
        void trans();
    }

    public static class MicroAdapter implements Usb {
        private MicroUsb instance = new MicroUsb();

        @Override
        public void charge() {
            System.out.println(instance.microCharge());
        }

        @Override
        public void trans() {
            System.out.println(instance.microTrans());
        }
    }

    public static class TypeAdapter implements Usb {
        private TypeC instance = new TypeC();

        @Override
        public void charge() {
            System.out.println(instance.typeCharge());
        }

        @Override
        public void trans() {
            System.out.println(instance.typeTrans());
        }
    }

}
