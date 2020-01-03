package cn.amos.chaos.test.pojo.request;

import lombok.Data;

/**
 * PROJECT: boot
 * DESCRIPTION: web请求表单
 *
 * @author amos.wang
 * @date 2019/4/30
 */
@Data
public class ParamConversionForm {

    private String name;

    private String address;

    private Integer age;

}
