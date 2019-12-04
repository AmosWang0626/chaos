package cn.amos.common.simple.thread.others;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/12/5
 */
public class LongAtomicity {

    private static long t = 0;

    private static class ChangeT implements Runnable {
        private long t;

        public ChangeT(long t) {
            this.t = t;
        }

        @Override
        public void run() {
            while (true) {
                LongAtomicity.t = t;
                Thread.yield();
            }
        }
    }

    private static class ReadT implements Runnable {

        @Override
        public void run() {
            while (true) {
                long t = LongAtomicity.t;
                if (t != 111L && t != -999L && t != 333L && t != -444L) {
                    System.out.println("THIS T IS " + t);
                    Thread.yield();
                }
            }
        }
    }

    /**
     * 32bit jvm 会报错
     */
    public static void main(String[] args) {
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ReadT()).start();
    }

}
