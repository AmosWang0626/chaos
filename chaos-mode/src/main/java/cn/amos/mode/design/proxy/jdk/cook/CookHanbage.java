package cn.amos.mode.design.proxy.jdk.cook;

import java.text.MessageFormat;

/**
 * NOTE: 类说明
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class CookHanbage implements Cook {

    @Override
    public void cooking(String arg1, String arg2) {
        System.out.println(MessageFormat.format("制作 Hamburger, 加入原材料 {0} {2}", arg1, arg2));
    }

}
