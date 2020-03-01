package com.amos.design.structure.bridge;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 桥接
 *
 * @author amos.wang
 */
public class Main {

    /**
     * 维度：
     * 手机：手机品牌；    聚合关系：弱"拥有"关系，A可以包含B，但B不是A的一部分。
     * 手机：内存/存储；   合成关系：强"拥有"关系，体现了严格的部分和整体的关系。
     */
    public static void main(String[] args) {
        // mi
        BasePhone phone = new Phones.MiPhone(
                new Memory.Memory8G(), new Storage.Storage128G());
        phone.info();

        phone = new Phones.MiPhone(
                new Memory.Memory16G(), new Storage.Storage256G());
        phone.info();

        // hua wei
        phone = new Phones.HuaWeiPhone(
                new Memory.Memory8G(), new Storage.Storage64G());
        phone.info();

        phone = new Phones.HuaWeiPhone(
                new Memory.Memory8G(), new Storage.Storage128G());
        phone.info();
    }

}
