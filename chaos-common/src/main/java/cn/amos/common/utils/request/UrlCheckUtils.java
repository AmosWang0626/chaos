package cn.amos.common.utils.request;

import java.util.regex.Pattern;

public class UrlCheckUtils {

    /**
     * 校验正则
     */
    private static final String CHECK_RULE = "^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~])+$";

    /**
     * 校验url是否合法
     *
     * @param url 网址
     * @return true: 合法
     */
    public static boolean checkUrl(String url) {
        return Pattern.compile(CHECK_RULE).matcher(url).matches();
    }

    public static void main(String[] args) {
        System.out.println(checkUrl("http://www.baidu.com"));
    }
}
