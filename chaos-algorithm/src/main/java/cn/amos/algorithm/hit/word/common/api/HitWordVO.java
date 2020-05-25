package cn.amos.algorithm.hit.word.common.api;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 模块名称: chaos
 * 模块描述: HitWordVO
 *
 * @author amos.wang
 * @date 2020/5/25 17:57
 */
@Getter
@Setter
@Accessors(chain = true)
public class HitWordVO {

    private Integer size;

    private List<String> words;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
