package com.amos.design.structure.proxy.cglib;

import java.text.MessageFormat;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/8
 */
public class VirtualDriver {

    public String drive(String model) {
        System.out.println(MessageFormat.format("\t自动驾驶 [{0}] >>>>>> 完成比赛", model));

        return "Perfect!";
    }

}
