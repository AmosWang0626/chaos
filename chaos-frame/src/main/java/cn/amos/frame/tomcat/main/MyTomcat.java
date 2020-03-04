package cn.amos.frame.tomcat.main;

import cn.amos.frame.tomcat.servlet.BaseServlet;
import cn.amos.frame.tomcat.servlet.MyHttpRequest;
import cn.amos.frame.tomcat.servlet.MyHttpResponse;
import cn.amos.frame.tomcat.servlet.MyServlet;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * DESCRIPTION: 手动实现一个Tomcat
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
public class MyTomcat {

    private static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("MyTomcat start by " + PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            // 解析request
            MyHttpRequest myHttpRequest = new MyHttpRequest(inputStream);
            myHttpRequest.parse();
            System.out.println(JSON.toJSONString(myHttpRequest));

            MyHttpResponse response = new MyHttpResponse(socket.getOutputStream());
            BaseServlet servlet = new MyServlet();
            try {
                servlet.service(myHttpRequest, response);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }

        }
    }

}
