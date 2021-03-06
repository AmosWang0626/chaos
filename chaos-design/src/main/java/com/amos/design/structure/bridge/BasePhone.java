package com.amos.design.structure.bridge;

/**
 * DESCRIPTION: 手机
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
public abstract class BasePhone {

    private Memory memory;
    private Storage storage;

    public BasePhone(Memory memory, Storage storage) {
        this.memory = memory;
        this.storage = storage;
    }

    /**
     * 品牌
     *
     * @return brand
     */
    public abstract String brand();

    /**
     * 手机信息
     */
    public void info() {
        String info = String.format("%s MemoryInfo: %s, StoreInfo: %s",
                brand(), memory.memoryInfo(), storage.storageInfo());
        System.out.println(info);
    }

}
