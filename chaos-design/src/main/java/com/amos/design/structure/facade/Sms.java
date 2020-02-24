package com.amos.design.structure.facade;

/**
 * DESCRIPTION: 短信
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public interface Sms {

    /**
     * 发送短信
     */
    void sendSms();

    class CtcImpl implements Sms {
        @Override
        public void sendSms() {
            System.out.print("中国电信-发送短信\t");
            System.out.println("http://www.chinatelecom.com.cn/");
        }
    }

    class CmcImpl implements Sms {
        @Override
        public void sendSms() {
            System.out.print("中国移动-发送短信\t");
            System.out.println("http://www.chinamobile.com/");
        }
    }

    class CucImpl implements Sms {
        @Override
        public void sendSms() {
            System.out.print("中国联通-发送短信\t");
            System.out.println("http://www.chinaunicom.com.cn/");
        }
    }

}
