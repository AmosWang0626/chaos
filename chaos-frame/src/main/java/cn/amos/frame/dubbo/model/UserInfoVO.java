package cn.amos.frame.dubbo.model;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 模块名称: chaos
 * 模块描述: UserInfoVO
 *
 * @author amos.wang
 * @date 2020/10/28 12:39
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserInfoVO {

    private String account;

    private String username;

    private String address;

    private Integer age;

    private GenderEnum gender;

    private BigDecimal totalConsume;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
