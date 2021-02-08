package cn.amos.chaos.test.xiaoi;

import java.text.MessageFormat;

/**
 * 模块名称: chaos
 * 模块描述: OA字数限制255，中文占3个字符
 *
 * @author amos.wang
 * @date 2021/2/8 18:05
 */
public class OaTest {

    private static final String CONTENT_OLD = "1.帮助中心-上传文件成功后不显示\n" +
            "2.文章编辑-选择标问拼接规则后导入无效\n" +
            "3.文档展示页面相关文档数据不一致\n" +
            "4.有辅分类阅读权限,知识展示页面路径错误\n" +
            "5.有辅分类下载权限,知识展示页面不能下载";

    private static final String CONTENT_NEW = "1.帮助中心-文件上传后不显示\n" +
            "2.文章编辑-标问拼接规则无效\n" +
            "3.文档展示页面相关文档数据不一致\n" +
            "4.有辅分类阅读权限,知识展示页面路径错误\n" +
            "5.有辅分类下载权限,知识展示页面不能下载";

    public static void main(String[] args) {
        statistics(CONTENT_OLD, 1);
        System.out.println("\n=================================================================\n");
        statistics(CONTENT_NEW, 1);
    }

    public static void statistics(String text, int type) {
        statistics(text, type, 0);
    }

    public static void statistics(String text, int type, int suggest) {
        if (type == 1) {
            System.out.println("检验OA日志内容开始:");
        }

        int txtLength = text.length();
        int chinese = chineseLength(text);
        int english = txtLength - chinese;

        int total = chinese * 3 + english;
        System.out.printf("\t中文字数：%d，英文字数：%d，总字符数：%d\t%s\n",
                chinese, english, total,
                suggest == 0 ? "" : MessageFormat.format(
                        "（建议总字数：{0}，建议中文字数：{1}）",
                        suggest, (suggest - english) / 3));

        if (type == 1) {
            if (total > 255) {
                System.out.println("检验完成! 字数过多，请删减片段 !!!\n");
                analysis(text);
            } else {
                System.out.println("检验完成! Congratulations! 校验通过 !!!");
            }
        }
    }

    public static void analysis(String text) {
        String[] split = text.split("\n");
        int suggest = 255 / split.length;
        for (String row : split) {
            System.out.println("原始文本: " + row);
            statistics(row, 0, suggest);
        }
    }

    public static int chineseLength(String text) {
        String Reg = "^[\u4e00-\u9fa5]$";
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            String b = Character.toString(text.charAt(i));
            if (b.matches(Reg)) result++;
        }
        return result;
    }

}
