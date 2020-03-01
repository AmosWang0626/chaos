package com.amos.design.structure.facade;

/**
 * DESCRIPTION: 短信 实现类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public class SmsImpls implements Sms {

    public static Sms getInstance() {
        return new SmsImpls();
    }

    @Override
    public void sendSms() {
        System.out.println("给所有手机用户发送通知短信");
        // 这里简便起见，子系统接口也叫 sendSms
        // 正常来说，不同的实现，接口方法也不尽相同，此处只是提供一个高层接口调用。
        new CtcImpl().sendSms();
        new CmcImpl().sendSms();
        new CucImpl().sendSms();
    }


    private static class CtcImpl implements Sms {
        @Override
        public void sendSms() {
            System.out.print("中国电信-发送短信\t");
            System.out.println("http://www.chinatelecom.com.cn/");
        }
    }

    private static class CmcImpl implements Sms {
        @Override
        public void sendSms() {
            System.out.print("中国移动-发送短信\t");
            System.out.println("http://www.chinamobile.com/");
        }
    }

    private static class CucImpl implements Sms {
        @Override
        public void sendSms() {
            System.out.print("中国联通-发送短信\t");
            System.out.println("http://www.chinaunicom.com.cn/");
        }
    }

}
