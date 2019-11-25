package cn.amos.common.utils.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * DESCRIPTION: curl request utils
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/21
 */
public class CurlRequestUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurlRequestUtils.class);

    /**
     * "172.16.36.14:8000?id={id}&ques={ques}"
     *
     * @param command command
     * @return result
     */
    public static String command(String command) {
        StringBuilder sb = new StringBuilder().append("curl ").append(command);

        String result = null;
        Process pro = null;

        try {
            /// windows
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                pro = Runtime.getRuntime().exec(new String[]{"cmd", "/c", sb.toString()});
            } else {
                pro = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", sb.toString()});
            }

            if (pro.waitFor() == 0) {
                // 执行成功
                result = getStringByInputStream(pro.getInputStream());
                LOGGER.info("CURL 脚本内容 [{}], 执行成功, 执行结果 [{}]", sb.toString(), result);
            } else {
                LOGGER.error("CURL 脚本内容 [{}], 执行失败, 失败原因 [{}]", sb.toString(), getStringByInputStream(pro.getErrorStream()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("CURL 脚本内容 [{}], 执行异常", sb.toString());
        } finally {
            if (pro != null) {
                pro.destroy();
            }
        }

        return result;
    }

    /**
     * 获取InputStream里的数据
     */
    private static String getStringByInputStream(InputStream inputStream) throws IOException {
        InputStreamReader sr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(sr);
        StringBuilder lines = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            lines.append(line);
        }
        br.close();
        sr.close();
        return lines.toString();
    }


//    public static void main(String[] args) {
//        StringBuilder cmd = new StringBuilder()
//                .append("172.16.36.14:8000")
//                .append("/id=").append(UUID.randomUUID())
//                .append("%ques=\"").append("没有其他的费用了吧？因为上次那个建设 银行跟我说了一堆，我都搞不明白他到底说的什么。")
//                .append("\"");
//        System.out.println(command(cmd.toString()));
//    }

}
