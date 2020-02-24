package cn.amos.common.utils.base;

/**
 * DESCRIPTION: 字符串工具类
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/24/2020
 */
public class StringUtils {

    public static String repeat(String str, int deep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(repeat("-", 3));
    }

}
