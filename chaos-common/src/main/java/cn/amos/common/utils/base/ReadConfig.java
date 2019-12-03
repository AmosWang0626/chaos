package cn.amos.common.utils.base;

import java.util.ResourceBundle;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/9/21
 */
public class ReadConfig {

    private static volatile ReadConfig config = null;

    /**
     * 读取资源文件的类
     */
    private static ResourceBundle resourceBundle = null;
    /**
     * CONFIG NAME
     */
    private static final String FILE_NAME = "application-config";

    private ReadConfig() {
        resourceBundle = ResourceBundle.getBundle(FILE_NAME);
    }

    public static ReadConfig getInstance() {
        if (config == null) {
            config = new ReadConfig();
        }
        return config;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }


    public static void main(String[] args) {
        System.out.println(ReadConfig.getInstance().getValue("appKey"));
    }
}
