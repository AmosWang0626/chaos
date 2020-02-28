package com.amos.design.behavior.command;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * DESCRIPTION: 服务员
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/28/2020
 */
@Data
@Accessors(chain = true)
public class Invoker {

    private BaseCommand command;


    /**
     * 服务员通知烤串师傅烤串
     */
    public void executeCommand() {
        command.execute();
    }

}
