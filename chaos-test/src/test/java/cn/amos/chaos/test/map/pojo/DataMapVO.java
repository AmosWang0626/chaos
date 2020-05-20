package cn.amos.chaos.test.map.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * DESCRIPTION: SimpleVO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/12/4
 */
@Getter
@Setter
@Accessors(chain = true)
public class DataMapVO {

    private String id;

    private String name;

    private Map<String, DataMapVO> childrenMap;

    public DataMapVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
