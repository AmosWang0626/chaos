package cn.amos.common.utils.base;

import com.google.common.base.CaseFormat;

/**
 * PROJECT: chaos
 * DESCRIPTION: 下划线转驼峰
 *
 * @author Daoyuan
 * @date 2018/9/30
 */
public class HumpUtil {

    // lowerCamel           CaseFormat.LOWER_CAMEL;
    // lower-hyphen         CaseFormat.LOWER_HYPHEN;
    // lower_underscore     CaseFormat.LOWER_UNDERSCORE;
    // UpperCamel           CaseFormat.UPPER_CAMEL;
    // UPPER_UNDERSCORE     CaseFormat.UPPER_UNDERSCORE;

    public static void main(String[] args) {

        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "mobile_name_in_gray"));
    }
}
