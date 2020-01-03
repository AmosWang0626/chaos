package cn.amos.chaos.test.main;

import java.util.regex.Pattern;

/**
 * DESCRIPTION: hello
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/29
 */
public class ReplaceHtmlDomMain {

    private static Pattern HTML_LABEL_PATTERN = Pattern.compile("<[^>]+>");
    private static Pattern HTML_ANGLE_PATTERN = Pattern.compile("[<>]");

    public static void main(String[] args) {
        String text = "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\"><span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">下列关于替代号说法正确的是</font></span></span></span></span><br />\n" +
                "<span style=\"font-size:10.5pt\">>><<<》》<span style=\"font-family:Calibri\"><span style=\"font-size:10.5000pt\"><span style=\"font-family:宋体\"><font face=\"宋体\">1》》》》》》11列关于替代号说法正确的是</font></span></span></span></span><br />\n";

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            text += text;
        }
        /// way 1
        // System.out.println(text.replaceAll("<[^>]+>", "").replaceAll("[<>]", ""));
        text = HTML_LABEL_PATTERN.matcher(text).replaceAll("");
        text = HTML_ANGLE_PATTERN.matcher(text).replaceAll("");
        /// way 2
        // text = cleanHtml(text);
        System.out.println(text);
        System.out.println("耗时>>>>>" + (System.currentTimeMillis() - begin) + "ms");
    }

    public static String cleanHtml(String content) {
        while (content.contains("<")) {
            int index = content.indexOf("<");
            String subContent = content.substring(index);
            int index2 = subContent.indexOf(">");
            content = content.substring(0, index) + " " + content.substring(index + index2 + 1);
        }

        return content;
    }

}
