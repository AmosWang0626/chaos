package com.amos.design.behavior.command;

import lombok.Data;

/**
 * DESCRIPTION: 基础命令
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
@Data
public abstract class BaseCommand {

    private Receiver receiver;

    public BaseCommand(Receiver receiver) {
        this.receiver = receiver;
    }


    /**
     * 执行命令
     */
    public abstract void execute();
}
