package cn.amos.chaos.test.pojo.request;

import cn.amos.common.annotation.ParamConversion;
import lombok.Data;

/**
 * PROJECT: boot
 * DESCRIPTION: web请求表单
 *
 * @author amos.wang
 * @date 2019/4/30
 */
@Data
@ParamConversion(convert = ParamConversion.Convert.N2B)
public class ParamConversionClassForm {

    private String name;

    private String address;

    private Integer age;

}
