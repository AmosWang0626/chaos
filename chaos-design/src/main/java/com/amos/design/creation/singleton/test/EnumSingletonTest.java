package com.amos.design.creation.singleton.test;

import com.amos.design.creation.singleton.HolderSingleton;

/**
 * DESCRIPTION: 单例模式——枚举
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/5/10
 */
public class EnumSingletonTest {

    private enum HolderEnum {
        /***/
        INSTANCE;

        HolderEnum() {
            this.instance = new HolderSingleton();
        }

        private HolderSingleton instance;
    }

    public static HolderSingleton getInstance() {
        return HolderEnum.INSTANCE.instance;
    }

}
