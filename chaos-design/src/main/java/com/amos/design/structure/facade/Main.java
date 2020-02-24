package com.amos.design.structure.facade;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 外观
 *
 * @author amos.wang
 */
public class Main {

    public static void main(String[] args) {
        Sms sms = SmsImpls.getInstance();
        sms.sendSms();
    }

}
