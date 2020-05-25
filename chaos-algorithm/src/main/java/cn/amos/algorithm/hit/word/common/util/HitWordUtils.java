package cn.amos.algorithm.hit.word.common.util;

import cn.amos.algorithm.hit.word.common.api.HitWordVO;

/**
 * 模块名称: participle
 * 模块描述: 关键词命中接口
 *
 * @author amos.wang
 * @date 2020/5/25 14:34
 */
public class HitWordUtils {

    public static HitWordVO check() {

        return new HitWordVO().setSize(0).setWords(null);
    }

}
