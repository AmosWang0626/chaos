package com.amos.design.behavior.observer.afterjdk9;

import java.util.concurrent.Flow;

/**
 * DESCRIPTION: 多个用户
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/21/2020
 */
public class Persons {

    public static class Person1 implements Flow.Subscriber<String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>> " + item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
            subscription.cancel();
            System.out.println(this.getClass().getSimpleName() + " >>>>>> 已取消");
        }

        @Override
        public void onComplete() {
            System.out.println(this.getClass().getSimpleName() + " >>>>>> 已完成");
        }
    }

    public static class Person2 extends Person1 {
    }

    public static class Person3 extends Person1 {
    }

}
