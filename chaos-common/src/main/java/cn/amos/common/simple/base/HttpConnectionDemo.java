package cn.amos.common.simple.base;

import cn.amos.common.utils.other.URLParamUtil;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

/**
 * NOTE: Http连接测试类
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/7
 */
public class HttpConnectionDemo {

    public static void main(String[] args) {

        System.out.println(httpConnection());
    }

    /**
     * 客户端
     * getInputStream 输入流,是从服务器端给客户端返回的数据
     * getOutputStream 输出流,是客户端发送给服务器端的数据
     * 服务器端
     * getInputStream 输入流,是客户端发送给服务器端的数据流
     * getOutputStream 输出流,是服务器端返回给客户端的数据
     */
    private static String httpConnection() {
        String requestUrl = "http://www.microcn.top:8080/hello/person";
        String requestMethod = "post";

        // 要提交的参数
        Map<String, String> map = new TreeMap<>();
        map.put("name", "hello");
        map.put("content", "this is content!");

        // 如果是get请求方式,将参数拼接到url后边
        if ("GET".equals(requestMethod.toUpperCase())) {
            requestUrl += URLParamUtil.formatUrlMap(map, true, false);
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(requestUrl).openConnection();
            connection.setReadTimeout(6000);
            connection.setUseCaches(false);

            if ("POST".equals(requestMethod.toUpperCase())) {
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                outputStream.writeBytes(JSON.toJSONString(map));
                // 提交数据并关闭输出流
                outputStream.flush();
                outputStream.close();
            } else {
                connection.setRequestMethod("GET");
                connection.connect();
            }

            int responseCode = connection.getResponseCode();
            // 结果码 || 结果信息 || GET/POST
            System.out.println("ResponseCode：" + responseCode);
            System.out.println("ResponseMessage：" + connection.getResponseMessage());
            System.out.println("ResponseMethod：" + connection.getRequestMethod());

            // 获取输入流
            InputStream inputStream;
            if (HttpURLConnection.HTTP_OK == responseCode
                    || HttpURLConnection.HTTP_CREATED == responseCode
                    || HttpURLConnection.HTTP_ACCEPTED == responseCode) {
                inputStream = connection.getInputStream();
            } else {
                inputStream = connection.getErrorStream();
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder sb = new StringBuilder();
            bufferedReader.lines().forEach(sb::append);

            // 关闭连接
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();

            return sb.toString();
        } catch (Exception e) {
            System.out.println("fail ----->>> " + e.getMessage());
        }

        return null;
    }
}
