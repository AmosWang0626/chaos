package cn.amos.chaos.test.pojo.request;

import cn.amos.common.annotation.ParamConversion;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * PROJECT: boot
 * DESCRIPTION: web请求表单
 *
 * @author amos.wang
 * @date 2019/4/30
 */
@Data
public class ParamConversionFieldForm {

    @ParamConversion
    private String name;

    @ParamConversion(convert = ParamConversion.Convert.N2B)
    private String address;

    @NotNull
    private Integer age;

}
