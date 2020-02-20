package com.amos.design.main;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DESCRIPTION: Log Utils
 * 继承
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/20/2020
 */
public class LogUtils {

    private static abstract class BaseLog {

        protected abstract void print(String log);

        public void info(Object... param) {
            String params = Stream.of(param).map(Object::toString).collect(Collectors.joining(","));

            print(LocalDateTime.now() + " [INFO] " + params);
        }

        public void error(Throwable throwable, Object... param) {
            String params = Stream.of(param).map(Object::toString).collect(Collectors.joining(","));
            print(LocalDateTime.now() + " [ERROR] " + throwable.toString() + "\t" + params);
        }
    }

    private static class AaaLog extends BaseLog {
        @Override
        protected void print(String log) {
            System.out.println(this.getClass().getSimpleName() + "\t" + log);
        }
    }

    private static class BbbLog extends BaseLog {
        @Override
        protected void print(String log) {
            System.out.println(this.getClass().getSimpleName() + "\t" + log);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            BaseLog log = new Random().nextBoolean() ? new AaaLog() : new BbbLog();
            try {
                int num = 100 / (new Random().nextBoolean() ? 1 : 0);
                log.info(num);
            } catch (Throwable e) {
                log.error(e, "[100 / 0]");
            }
            System.out.println();
        }
    }

}
