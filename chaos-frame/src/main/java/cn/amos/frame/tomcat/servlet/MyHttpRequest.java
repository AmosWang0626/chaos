package cn.amos.frame.tomcat.servlet;

import cn.amos.frame.tomcat.utils.TomcatUtils;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * DESCRIPTION: MyHttpRequest
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
@Data
public class MyHttpRequest {

    private String method;

    private String url;

    private List<String> params;

    private InputStream inputStream;

    public MyHttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() throws IOException {
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        byte[] bytes = new byte[count];
        int read = inputStream.read(bytes);
        if (count != read) {
            System.out.println("available != read bytes !!!!!!!!!!!");
        }
        String requestHeader = new String(bytes);

        int firstNewline = requestHeader.indexOf("\n");
        String firstLine = requestHeader.substring(0, firstNewline);
        firstLine = firstLine.replace("\r", "");

        // 科普 \\s 表示空白字符
        String[] header = firstLine.split("\\s");
        if (!TomcatUtils.HTTP11.equals(header[2])) {
            System.out.println("ERROR: 请求协议暂不支持" + header[2]);
            return;
        }

        setMethod(header[0].toLowerCase());

        String url = header[1];
        int paramBegin = url.indexOf("?");

        // 不含参数 setUrl 
        if (paramBegin == -1) {
            setUrl(url);
            return;
        }

        // 含有参数 setUrl setParams 
        try {
            setUrl(url.substring(0, paramBegin));
            String[] split = url.substring(paramBegin + 1).split("&");
            List<String> list = new LinkedList<>();
            for (String str : split) {
                String[] temp = str.split("=");
                list.add(temp[1]);
            }
            setParams(list);
        } catch (Exception e) {
            System.out.println("ERROR: 参数格式错误");
        }
    }

}
