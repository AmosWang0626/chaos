package com.amos.design.structure.adapter;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 适配器
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        AdapterCore.Usb usb = new AdapterCore.MicroAdapter();
        usb.charge();
        usb.trans();
        System.out.println();
        usb = new AdapterCore.TypeAdapter();
        usb.charge();
        usb.trans();
    }

}
