package cn.amos.chaos.test.main;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;

/**
 * DESCRIPTION: Keyword
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2020/3/10
 */
public class KeywordMain {

    /**
     * 后边使用解释器模式改造
     */
    public static void main(String[] args) {
        System.out.println(checkAnd("你好呀，我是AMOS，很高兴认识你，。。。再见", "你好 and 再见"));
        System.out.println(checkOr("你好呀，我是AMOS，很高兴认识你", "你好 or 再见"));
        System.out.println(checkNot("你好呀，我是AMOS，很高兴认识你", "not您好"));
    }

    public static boolean checkAnd(String keyword, String expression) {
        expression = expression.replace(" ", "");
        HashSet<String> ands = new HashSet<>(Arrays.asList(expression.split("and")));
        int keySum = 0;
        for (String str : ands) {
            if (keyword.contains(str)) {
                keySum++;
            }
        }
        return keySum >= ands.size();
    }

    public static boolean checkOr(String keyword, String expression) {
        expression = expression.replace(" ", "");
        for (String str : expression.split("or")) {
            if (keyword.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNot(String keyword, String expression) {
        expression = expression.replace(" ", "");
        for (String str : expression.split("not")) {
            if (StringUtils.isNotBlank(str) && keyword.contains(str)) {
                return false;
            }
        }
        return true;
    }

}

/*
and : 左右两个关键词必须同时存在。例如:“你好 and 再见”，任务中既包含“你好”关键词又包含“再见”关键词才符合该规则。
or : 左右两个关键词存在一个即可。例如:“你好 or 再见”，任务中无论含有“你好”关键词还是 “再见”关键词均符合该规则。
not : 不存在该关键词。例如:“not 你好”，任务中没有“你好”关键词的均符合该规则。
after : 先出现after左面的关键词，后出现after右面的关键词，且两个关键词的之间的不能超过N( 匹配距离可在参数配置页面进行设置 )个词。例如:“你 after 好”，任务中先出现 “你”，	在“你”后面的连续N个词中又出现“好”的，则符合该规则。
3连after: 两个after连用, 如 A after B after C，其中A、B、C代表关键词表示3个关键词同时存在且先出现A，后出现B，最后出现C，并且每两个关键词之间不能超过N（匹配距离可在参数配置页面进行设置）个词。
near : 左右两个关键词的中间不能超过N( 匹配距离可在参数配置页面进行设置 )个词，无需考虑这两个关键词出现的先后顺序。例如:“你 near 好”，任务中只要出现“你”、“好”这两个关键词的，并且这两个词之间的词不超过N个的均符合该规则。 
() : 用于改变局部模型的执行顺序。例如:“（你 after 好）or 您好”，会将“你 after 好”看成一个局部规则，而不是把“好 or 您好”看成一个局部规则。
freq: 用于指定关键词出现的位置，格式为“W offset n,m”，W代表关键词，n，m代表在文本中出现的位置范围，n、m必须为正整数，且 n < m ；
offset: 用于指定关键词出现的位置，格式为“W offset n,m”，W代表关键词，n，m代表在文本中出现的位置范围，n、m必须为正整数，且 n < m ；
注：关键字匹配优先顺序依次为(同级关键字从左到右顺序匹配)：() > after/near/offset/freq > not > and/or
*/