package com.amos.design.behavior.command;

/**
 * DESCRIPTION: 命令集合
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
public interface Commands {

    class BeefCommand extends BaseCommand {
        public BeefCommand(Receiver receiver) {
            super(receiver);
        }

        @Override
        public void execute() {
            String name = "烤牛肉串";
            System.out.println("烤串师傅 >>> " + name);
            getReceiver().finish(name);
        }
    }

    class LambCommand extends BaseCommand {
        public LambCommand(Receiver receiver) {
            super(receiver);
        }

        @Override
        public void execute() {
            String name = "烤羊肉串";
            System.out.println("烤串师傅 >>> " + name);
            getReceiver().finish(name);
        }
    }

}
