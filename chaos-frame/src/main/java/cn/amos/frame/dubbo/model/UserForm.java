package cn.amos.frame.dubbo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 模块名称: chaos
 * 模块描述: UserForm
 *
 * @author amos.wang
 * @date 2020/10/28 12:38
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserForm {

    private String account;

    private String password;

    private String username;

    private String address;

    private Integer age;

    private GenderEnum gender;

    private BigDecimal totalConsume;

}
