package cn.amos.frame.tomcat.utils;

import org.springframework.http.HttpStatus;

/**
 * DESCRIPTION: Tomcat工具类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
public class TomcatUtils {

    public static final String HTTP11 = "HTTP/1.1";
    public static final String GET = "get";
    public static final String POST = "post";


    public static String getHttpResponse(HttpStatus status, String body) {
        if (HttpStatus.OK == status) {
            return String.format("%s %s %s \n Content Type: text/html\n\r\n%s",
                    HTTP11, status.value(), status.getReasonPhrase(), body);
        }
        return String.format("%s %s %s \n Content Type: text/html\n\r\n",
                HTTP11, status.value(), status.getReasonPhrase());
    }

}
