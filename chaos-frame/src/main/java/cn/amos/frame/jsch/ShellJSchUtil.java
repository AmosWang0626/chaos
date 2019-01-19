package cn.amos.frame.jsch;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * PROJECT: chaos
 * DESCRIPTION: JSch 连接 Linux Util
 *
 * @author Daoyuan
 * @date 2019/1/18
 */
public class ShellJSchUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShellJSchUtil.class);

    /**
     * shell default port
     */
    private static final int DEFAULT_SSH_PORT = 22;
    /**
     * single session
     */
    private static volatile Session session;

    public static Session getInstance(String host, String name, String password) throws JSchException {
        return getInstance(host, name, password, DEFAULT_SSH_PORT);
    }

    public static Session getInstance(String host, String name, String password, int post) throws JSchException {
        if (session != null) {
            return session;
        }
        return initSession(host, name, password, post);
    }

    public static List<String> execCmd(Session session, String cmd) throws JSchException, IOException {
        long begin = System.currentTimeMillis();
        LOGGER.info(">>>>>>>>> 执行命令 {} 开始...", cmd);
        List<String> callback = new ArrayList<>();
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.setInputStream(null);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        InputStream inputStream = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String buf;
        while ((buf = reader.readLine()) != null) {
            callback.add(buf);
        }
        reader.close();
        channelExec.disconnect();
        LOGGER.info(">>>>>>>>> 执行命令 {} 完成. >>> [耗时 {} 毫秒]", cmd, (System.currentTimeMillis() - begin));

        return callback;
    }

    private static Session initSession(String host, String name, String password, int port) throws JSchException {
        JSch jsch = new JSch();
        session = jsch.getSession(name, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        return session;
    }

    public static void closeSession() {
        if (session != null) {
            session.disconnect();
        }
    }

}
