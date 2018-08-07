package cn.amos.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * NOTE: Http连接工具类
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class HttpConnectionUtil {

    private static String get(String strUrl) {
        StringBuilder sb = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(strUrl).openConnection();
            connection.connect();

            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            br.lines().forEach(sb::append);

            br.close();
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("fail " + e.getMessage());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(get("https://www.baidu.com"));
    }
}
