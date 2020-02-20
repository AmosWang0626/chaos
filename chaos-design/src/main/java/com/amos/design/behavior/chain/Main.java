package com.amos.design.behavior.chain;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: 设计模式 —— 责任链
 *
 * @author Daoyuan
 * @date 2019/3/20
 */
public class Main {

    public static void main(String[] args) {
        NoticeUtils.BaseNotice supervisor = new NoticeUtils.NoticeSupervisor();
        NoticeUtils.BaseNotice manager = new NoticeUtils.NoticeManager();
        NoticeUtils.BaseNotice boss = new NoticeUtils.NoticeBoss();

        manager.setNextNotice(supervisor);
        boss.setNextNotice(manager);

        boss.notice(NoticeUtils.NoticeLevel.BOSS, "BOSS 1号通知");
        System.out.println();
        boss.notice(NoticeUtils.NoticeLevel.MANAGER, "MANAGER 2号通知");
        System.out.println();
        boss.notice(NoticeUtils.NoticeLevel.SUPERVISOR, "SUPERVISOR 3号通知");
    }

}
