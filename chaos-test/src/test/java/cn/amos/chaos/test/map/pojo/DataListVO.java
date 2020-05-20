package cn.amos.chaos.test.map.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * DESCRIPTION: SimpleVO
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/12/4
 */
@Getter
@Setter
@Accessors(chain = true)
public class DataListVO {

    private String id;

    private String name;

    private Set<DataListVO> children;

    public DataListVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(((DataListVO) obj).id);
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
