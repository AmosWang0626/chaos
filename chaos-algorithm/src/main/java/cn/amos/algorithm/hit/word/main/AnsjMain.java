package cn.amos.algorithm.hit.word.main;

import cn.amos.algorithm.hit.word.common.util.AnsjUtils;

/**
 * 模块名称: participle
 * 模块描述: AnsjMain
 *
 * @author amos.wang
 * @date 2020/5/25 11:45
 */
public class AnsjMain {

    public static void main(String[] args) {
        String str = "今年的政府工作报告没有提出全年经济增速具体目标，而是强调优先稳就业保民生，坚决打赢脱贫攻坚战，" +
                "努力实现全面建成小康社会目标任务。这其中有何考量？下半年中国经济发展前景如何？应该如何做好“六稳”、" +
                "“六保 ”工作？带着这些问题，我们在全国政协十三届三次会议网络视频采访间，邀请全国政协常委、经济委员会" +
                "副主任杨伟民，听听他的权威解读。";

        System.out.println(AnsjUtils.parse(str));

        System.out.println(AnsjUtils.allWords(str));
    }
}
