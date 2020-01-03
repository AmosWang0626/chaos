package cn.amos.chaos.test.web.controller;

import cn.amos.chaos.test.pojo.request.ParamConversionForm;
import cn.amos.common.annotation.MethodParamConversion;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

/**
 * DESCRIPTION: 前后端分离，前端字段默认值一般是""，后端更希望拿到的是null，故自定义注解过滤下
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 1/3/2020
 */
@RestController
@RequestMapping("conversion")
public class ParamConversionController {

    @PostMapping("b2n")
    @MethodParamConversion
    public String b2n(@RequestBody ParamConversionForm form) {

        return JSON.toJSONString(form);
    }

    @PostMapping("n2b")
    @MethodParamConversion(convert = MethodParamConversion.Convert.N2B)
    public String n2b(@RequestBody ParamConversionForm form) {

        return JSON.toJSONString(form);
    }

    /**
     * @see MethodParamConversion 只能作用于参数是表单的形式，如下则不生效，原因：直接作用于 “基本数据类型” 效果不好
     */
    @GetMapping("simple")
    @MethodParamConversion
    public String simple(String name) {
        return name;
    }


}
