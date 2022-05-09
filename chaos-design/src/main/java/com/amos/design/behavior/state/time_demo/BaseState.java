package com.amos.design.behavior.state.time_demo;

/**
 * DESCRIPTION: 状态管理
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/27/2020
 */
public abstract class BaseState {

    /**
     * 工作
     *
     * @param work Work
     */
    public abstract void work(Work work);


    /**
     * MorningState 上午
     */
    public static class MorningState extends BaseState {
        @Override
        public void work(Work work) {
            if (work.getHour() < 12) {
                print(work.getHour(), "上午, 做些重要的事情哦");
            } else {
                work.setState(new NoonState());
                work.atWork();
            }
        }
    }

    /**
     * NoonState 中午
     */
    public static class NoonState extends BaseState {
        @Override
        public void work(Work work) {
            if (work.getHour() < 14) {
                print(work.getHour(), "中午, 吃完饭, 不要久坐, 也要休息一会儿哈");
            } else {
                work.setState(new AfternoonState());
                work.atWork();
            }
        }
    }

    /**
     * AfternoonState
     */
    public static class AfternoonState extends BaseState {
        @Override
        public void work(Work work) {
            if (work.getHour() < 18) {
                print(work.getHour(), "下午, 打起精神呦, 先做优先级高的事情");
            } else {
                work.setState(new DuskState());
                work.atWork();
            }
        }
    }

    /**
     * DuskState
     */
    public static class DuskState extends BaseState {
        @Override
        public void work(Work work) {
            if (work.getHour() < 19) {
                print(work.getHour(), "傍晚了, 吃点美食, 结束忙碌的一天吧");
            } else {
                work.setState(new NightState());
                work.atWork();
            }
        }
    }

    /**
     * NightState
     */
    public static class NightState extends BaseState {
        @Override
        public void work(Work work) {
            if (work.getHour() < 22) {
                print(work.getHour(), "在工作吗, 在的话要早点下班呦");
            }
        }
    }

    private static void print(int hour, String message) {
        System.out.printf("[北京时间: %d点整] \t%s\n", hour, message);
    }


}
