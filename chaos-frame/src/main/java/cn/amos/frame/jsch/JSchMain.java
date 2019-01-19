package cn.amos.frame.jsch;

import com.alibaba.fastjson.JSON;
import com.jcraft.jsch.Session;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/1/18
 */
public class JSchMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSchMain.class);

    private static final String HOST = "47.106.227.226";
    private static final String USER = "root";
    private static final String PASSWORD = "Dyt19951014";
    private static final String IP_REGEX = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";

    public static void main(String[] args) {
        LOGGER.info("add ip status : {}", addIp("192.168.1.3"));
    }

    private static boolean addIp(String ip) {
        if (!formatCorrect(ip)) {
            LOGGER.error("IP [{}] 格式错误", ip);
            return false;
        }

        List<String> strings;
        String cmdExistIp = "cat /etc/nginx/block_ip.txt";
        String cmdAddIp = "./white_ip.sh " + ip;
        AtomicBoolean ipExist = new AtomicBoolean(false);
        try {
            long begin = System.currentTimeMillis();
            Session session = ShellJSchUtil.getInstance(HOST, USER, PASSWORD);
            LOGGER.info(">>>>>>>>> 连接 [{}] 成功. [耗时 {} 毫秒]", HOST, (System.currentTimeMillis() - begin));

            // 遍历执行结果, IP 不能重复添加
            strings = ShellJSchUtil.execCmd(session, cmdExistIp);
            strings.forEach(str -> {
                if (str.contains(ip)) {
                    ipExist.set(true);
                }
            });
            if (ipExist.get()) {
                LOGGER.error("IP [{}] 已存在,请勿重复添加", ip);
                return false;
            }

            strings = ShellJSchUtil.execCmd(session, cmdAddIp);
            LOGGER.info(JSON.toJSONString(strings));
        } catch (Exception ignore) {
        } finally {
            ShellJSchUtil.closeSession();
        }
        return false;
    }

    /**
     * 校验 IP 格式
     *
     * @param ip IP地址
     * @return true IP格式正确；false：格式错误。
     */
    private static boolean formatCorrect(String ip) {
        if (StringUtils.isBlank(ip)) {
            return false;
        }
        Matcher matcher = Pattern.compile(IP_REGEX).matcher(ip);
        if (matcher.matches()) {
            String[] split = ip.split("\\.");
            for (String str : split) {
                if (Integer.valueOf(str) > 255) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
