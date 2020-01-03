package cn.amos.common.annotation;

import java.lang.annotation.*;

/**
 * DESCRIPTION: method param converter
 *
 * @author amos.wang
 * @date 2019/4/30
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodParamConversion {

    Convert convert() default Convert.B2N;

    /**
     * B2N: String ["" to null]
     * N2B: String [null to ""]
     */
    enum Convert {/***/ B2N, N2B}

}
