package cn.amos.frame.tomcat.config;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION: ServletMapping
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
public class ServletMapping {

    private static Map<String, ServletConfig> MAPPING = new HashMap<>();

    static {
        add(new ServletConfig("hello", "/hello",
                "cn.amos.frame.tomcat.controller.HelloController"));
        add(new ServletConfig("sum", "/sum",
                "cn.amos.frame.tomcat.controller.HelloController"));
    }

    public static void add(ServletConfig config) {
        MAPPING.put(config.getUrlMapping(), config);
    }

    public static ServletConfig get(String name) {
        return MAPPING.get(name);
    }

}
