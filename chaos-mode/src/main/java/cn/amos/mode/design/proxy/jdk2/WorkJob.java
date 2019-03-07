package cn.amos.mode.design.proxy.jdk2;

import java.text.MessageFormat;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class WorkJob implements Work {

    @Override
    public void cooking(String arg1, String arg2) {
        System.out.println(MessageFormat.format("做饭 [原材料：{0} {1}]", arg1, arg2));
    }

    @Override
    public void write(String arg1, String arg2) {
        System.out.println(MessageFormat.format("写文章 [标题：{0}; 内容：{1}]", arg1, arg2));
    }

}
