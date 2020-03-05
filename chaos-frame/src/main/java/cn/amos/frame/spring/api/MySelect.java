package cn.amos.frame.spring.api;

import java.lang.annotation.*;

/**
 * DESCRIPTION: MySelect
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MySelect {

    String[] value() default {};

}
