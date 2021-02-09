package cn.amos.chaos.test.xiaoi;

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

    public static void main(String[] args) {
        statisticsContent(CONTENT_OLD);
    }

    /**
     * 解析全文
     */
    public static void statisticsContent(String text) {
        System.out.println("检验OA日志内容开始:");

        int txtLength = text.length();
        int chinese = chineseLength(text);
        int english = txtLength - chinese;

        int total = chinese * 3 + english;
        System.out.printf("\t中文字数：%d，英文字数：%d，总字符数：%d\n", chinese, english, total);

        if (total > 255) {
            System.out.println("检验完成! 字数过多，请删减片段 !!! 详细分析如下 ↓↓↓↓↓↓↓\n");
            analysis(text);
        } else {
            System.out.println("检验完成! 校验通过! Congratulations!!!");
        }
    }

    /**
     * 分析每行
     */
    public static void analysis(String text) {
        String[] split = text.split("\n");
        int suggest = 255 / split.length;
        for (String row : split) {
            System.out.println(row);
            statisticsRow(row, suggest);
        }
    }

    /**
     * 解析每行
     */
    public static void statisticsRow(String text, int suggest) {
        int txtLength = text.length();
        int chinese = chineseLength(text);
        int english = txtLength - chinese;

        int total = chinese * 3 + english;
        if (total <= suggest) {
            System.out.printf("\t中文字数：%d，英文字数：%d，总字符数：%d\n", chinese, english, total);
        } else {
            System.out.printf("\t中文字数：%d（建议：%d），英文字数：%d，总字符数：%d（建议：%d）\n",
                    chinese, (suggest - english) / 3, english, total, suggest);
        }
    }

    private static int chineseLength(String text) {
        String Reg = "^[\u4e00-\u9fa5]$";
        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            String b = Character.toString(text.charAt(i));
            if (b.matches(Reg)) result++;
        }
        return result;
    }

}
