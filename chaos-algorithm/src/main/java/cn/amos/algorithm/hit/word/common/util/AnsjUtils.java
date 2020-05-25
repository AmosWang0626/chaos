package cn.amos.algorithm.hit.word.common.util;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 模块名称: participle
 * 模块描述: 分词工具类
 *
 * @author amos.wang
 * @date 2020/5/25 13:45
 * SEE: https://github.com/NLPchina/ansj_seg
 */
public class AnsjUtils {

    /**
     * 获取一句话中所有的词
     *
     * @param source 原始文本
     * @return 所有分词结果（不包含标点符号）
     */
    public static List<String> allWords(String source) {
        Result result = ToAnalysis.parse(source);
        if (result == null || result.getTerms() == null || result.getTerms().size() == 0) {
            return Collections.emptyList();
        }

        return result.getTerms().stream()
                // 过滤掉所有标点符号
                .filter(term -> !"w".equals(term.getNatureStr()))
                .map(Term::getRealName)
                .collect(Collectors.toList());
    }

    /**
     * 封装一下
     *
     * @param source parse
     * @return Result
     */
    public static Result parse(String source) {
        return ToAnalysis.parse(source);
    }

}
