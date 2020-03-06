package cn.amos.frame.mybatis.plugin;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * DESCRIPTION: PageModule
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/6/2020
 */
@Setter
@Getter
@Accessors(chain = true)
public class PageModule {

    private Integer page;

    private Integer size;

    private Integer start;

    private Integer count;

    public Integer getStart() {
        return size * (page - 1);
    }
}
