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
    public String hello(@RequestBody ParamConversionForm form) {

        return JSON.toJSONString(form);
    }

    @PostMapping("n2b")
    @MethodParamConversion(convert = MethodParamConversion.Convert.N2B)
    public String hello2(@RequestBody ParamConversionForm form) {

        return JSON.toJSONString(form);
    }

    @GetMapping("simple")
    @MethodParamConversion
    public String hello(String name) {
        return name;
    }


}
