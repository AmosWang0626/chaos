package cn.amos.frame.tomcat.servlet;

import cn.amos.frame.tomcat.utils.TomcatUtils;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.OutputStream;

/**
 * DESCRIPTION: MyHttpResponse
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
@Data
public class MyHttpResponse {

    private OutputStream outputStream;

    public MyHttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void format(HttpStatus status, String body) throws IOException {
        String response = TomcatUtils.getHttpResponse(status, body);
        outputStream.write(response.getBytes());
    }

}
