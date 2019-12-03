package cn.amos.common.utils.request;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * NOTE: URL参数相关工具类
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class UrlParamUtils {

    /**
     * 方法用途: 对所有传入参数按照key排序,并生成url参数串
     *
     * @param paramMap  要排序的参数Map集合
     * @param setEncode 是否需要设置编码
     *                  true: set encode UTF-8
     * @param key2Lower 是否需要将key转换为全小写
     *                  true: key to lower
     * @return 拼接后生成的url
     */
    public static String formatUrlMap(Map<String, String> paramMap, boolean setEncode, boolean key2Lower) {
        StringBuilder builder = new StringBuilder();
        builder.append("?");
        try {
            // 利用TreeMap的有序性 (如果转化成List一般耗时45ms, 本方法仅需5ms)
            if (!(paramMap instanceof TreeMap)) {
                paramMap = new TreeMap<>(paramMap);
            }

            Iterator<String> iterator = paramMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String val = paramMap.get(key);
                if (StringUtils.isNotBlank(key)) {
                    if (setEncode) {
                        val = URLEncoder.encode(val, "utf-8");
                    }
                    if (key2Lower) {
                        builder.append(key.toLowerCase()).append("=").append(val);
                    } else {
                        builder.append(key).append("=").append(val);
                    }
                    if (iterator.hasNext()) {
                        builder.append("&");
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", "amos");
        paramMap.put("age", "16");
        paramMap.put("home", "heNan");

        new Thread(() -> System.out.println(formatUrlMap(paramMap, true, true))).start();
    }
}
