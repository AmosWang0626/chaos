package cn.amos.chaos.test.main;

import java.util.regex.Pattern;

/**
 * DESCRIPTION: substring test main
 *
 * @author amos.wang
 * @date 2019/9/29
 */
public class SubExtractMain {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");


    public static void main(String[] args) {
        String content = "<p style=\"width: 100px; height: auto\">amos.wang<amos.wang@xiaoi.com.cn>, daoyuan.wang<daoyuan.wang@xiaoi.com.cn><p>";
        while (content.contains("<")) {
            int index = content.indexOf("<");
            String subContent = content.substring(index);
            int index2 = subContent.indexOf(">");

            // 校验是否是邮箱
            String emailContent = content.substring(index + 1, index + index2);
            boolean isEmail = EMAIL_PATTERN.matcher(emailContent).find();
            System.out.println(String.format("%s 是邮箱？ %s", emailContent, isEmail ? "是" : "不是"));
            // 校验完成

            if (isEmail) {
                content = content.replaceFirst("<", "[");
                content = content.replaceFirst(">", "]");
            } else {
                content = content.substring(0, index) + " " + content.substring(index + index2 + 1);
            }
        }
        System.out.println(content);
    }

}
