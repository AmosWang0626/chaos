package cn.amos.chaos.test.dao.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DESCRIPTION: user group 联合主键 @IdClass
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2019/11/27
 */
@Getter
@Setter
public class UserGroupIds implements Serializable {

    private String user;
    private String group;

}
