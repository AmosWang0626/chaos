package cn.amos.frame.tomcat.config;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * DESCRIPTION: ServletConfig
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
@Data
@Accessors(chain = true)
public class ServletConfig {

    private String name;

    private String urlMapping;

    private String clazz;


    public ServletConfig(String name, String urlMapping, String clazz) {
        this.name = name;
        this.urlMapping = urlMapping;
        this.clazz = clazz;
    }

}
