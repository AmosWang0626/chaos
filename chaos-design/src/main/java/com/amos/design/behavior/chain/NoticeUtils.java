package com.amos.design.behavior.chain;

import lombok.Getter;
import lombok.Setter;

/**
 * DESCRIPTION: Log Utils
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/20/2020
 */
public class NoticeUtils {
    /**
     * 通知级别
     */
    public interface NoticeLevel {
        int BOSS = 1;
        int MANAGER = 2;
        int SUPERVISOR = 3;
    }

    @Getter
    @Setter
    public static abstract class BaseNotice {

        protected BaseNotice nextNotice;

        protected int level;

        public void notice(int level, String message) {
            if (this.level >= level) {
                sendNotice(message);
            }
            if (nextNotice != null) {
                nextNotice.notice(level, message);
            }
        }

        /**
         * 发送通知
         *
         * @param message 通知内容
         */
        public abstract void sendNotice(String message);
    }

    /**
     * [低] 主管级别
     */
    public static class NoticeSupervisor extends BaseNotice {
        public NoticeSupervisor() {
            this.level = NoticeLevel.SUPERVISOR;
        }

        @Override
        public void sendNotice(String message) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>>>>>> " + message);
        }
    }

    /**
     * [中] 经理级别
     */
    public static class NoticeManager extends BaseNotice {
        public NoticeManager() {
            this.level = NoticeLevel.MANAGER;
        }

        @Override
        public void sendNotice(String message) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>>>>>> " + message);
        }
    }

    /**
     * [高] Boss级别
     */
    public static class NoticeBoss extends BaseNotice {
        public NoticeBoss() {
            this.level = NoticeLevel.BOSS;
        }

        @Override
        public void sendNotice(String message) {
            System.out.println(this.getClass().getSimpleName() + " >>>>>>>>>> " + message);
        }
    }

}
