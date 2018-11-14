package cn.amos.common.utils.other;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * PROJECT: chaos <br>
 * DESCRIPTION: notes
 *
 * @author wangdaoyuan
 * @date 2018/9/4
 */
public class PwdUtil {

    private static Pattern PATTERN = Pattern.compile("^.*[\\s]+.*$");

    public static void main(String[] args) {
        String password = "xgfc.hvjbkn";
        // password = new Random().nextBoolean() ? password + " " : password;

        int rule = pwdRule(password);
        System.out.println("符合规则数目 " + rule);
    }

    private static int pwdRule(String password) {
        if (PATTERN.matcher(password).find()) {
            System.out.println("密码中不能带空格");
            return 0;
        }

        /*
         * 特殊字符
         * 数字
         * 小写字母
         * 大写字母
         */
        List<String> rules = new ArrayList<>();
        rules.add("[`~!?@#$%^&\\*\\(\\)\\+=|{}':;',\\[\\].<>/！￥……（）——{}【】‘；：”“’。，、？]+");
        rules.add("[\\d]+");
        rules.add("[a-z]+");
        rules.add("[A-Z]+");

        int oks = 0;

        for (String rule : rules) {
            PATTERN = Pattern.compile(rule);
            if (PATTERN.matcher(password).find()) {
                oks++;
            }
        }

        return oks;
    }

}
