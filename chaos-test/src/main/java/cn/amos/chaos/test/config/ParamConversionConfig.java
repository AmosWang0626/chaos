package cn.amos.chaos.test.config;

import cn.amos.common.annotation.ParamConversionAop;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * DESCRIPTION: Param Conversion
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 1/3/2020
 */
@Aspect
@Configuration
public class ParamConversionConfig implements ParamConversionAop {

    @Override
    public String basePackage() {
        return "cn.amos.chaos.test.pojo";
    }

}
