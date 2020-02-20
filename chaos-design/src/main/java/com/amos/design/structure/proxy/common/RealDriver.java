package com.amos.design.structure.proxy.common;

import java.text.MessageFormat;

/**
 * PROJECT: chaos-design
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/8
 */
public class RealDriver implements DriveInterface {

    private String name;

    public RealDriver(String name) {
        this.name = name;
    }

    @Override
    public String drive(String model) {
        System.out.println(MessageFormat.format("\t车手 [{0}] 驾驶 [{1}] >>>>>> 完成比赛", name, model));

        return "Very good!";
    }

}
