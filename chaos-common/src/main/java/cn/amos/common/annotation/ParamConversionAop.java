package cn.amos.common.annotation;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import java.lang.reflect.Field;

/**
 * DESCRIPTION: Method Param Converter AOP
 *
 * @author amos.wang
 * @date 2019/4/30
 * @see ParamConversion
 * @see MethodParamConversion
 */
public interface ParamConversionAop {

    /**
     * must set base package
     *
     * @return your base package
     */
    String basePackage();


    /**
     * check args and conversion
     *
     * @param joinPoint             aop point
     * @param methodParamConversion conversion type
     */
    @Before("@annotation(methodParamConversion)")
    default void checkAndConversion(JoinPoint joinPoint, MethodParamConversion methodParamConversion) {
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            try {
                if (undefined(obj)) {
                    return;
                }
                conversion(obj, methodParamConversion.convert());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Only convert classes defined in basePackage
     *
     * @param object object
     * @return defined in basePackage return true
     */
    default boolean undefined(Object object) {
        Class<?> clazz = object.getClass();
        if (clazz.getPackage() == null) {
            return true;
        }
        return !clazz.getPackage().toString().contains(basePackage());
    }

    /**
     * do conversion
     *
     * @param object  object
     * @param convert B2N or N2B
     * @throws IllegalAccessException Field get/set exception
     * @see MethodParamConversion.Convert
     */
    default void conversion(Object object, MethodParamConversion.Convert convert) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (String.class != field.getType()) {
                return;
            }
            // 类中的成员变量为private, 故必须进行此操作
            field.setAccessible(true);
            String fieldValue = (String) field.get(object);
            if (MethodParamConversion.Convert.B2N.equals(convert)) {
                if (StringUtils.isBlank(fieldValue)) {
                    field.set(object, null);
                }
            } else if (MethodParamConversion.Convert.N2B.equals(convert)) {
                if (fieldValue == null) {
                    field.set(object, "");
                }
            }
        }
    }

}
