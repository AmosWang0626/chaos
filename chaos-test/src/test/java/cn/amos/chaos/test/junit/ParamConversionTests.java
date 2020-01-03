package cn.amos.chaos.test.junit;

import cn.amos.chaos.test.pojo.request.ParamConversionClassForm;
import cn.amos.chaos.test.pojo.request.ParamConversionFieldForm;
import cn.amos.common.annotation.ParamConversion;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
public class ParamConversionTests {

    @Test
    public void testObjectField() throws IllegalAccessException {
        ParamConversionFieldForm helloFieldForm = new ParamConversionFieldForm();
        helloFieldForm.setName("");
        helloFieldForm.setAddress(null);
        helloFieldForm.setAge(18);

        checkFieldParam(helloFieldForm);
        System.out.println(helloFieldForm.toString());

        System.out.println(">>>>>>> 华丽丽的分割线 <<<<<<<<<");

        ParamConversionClassForm helloClassForm = new ParamConversionClassForm();
        helloClassForm.setName("");
        helloClassForm.setAddress(null);
        helloClassForm.setAge(18);

        checkClassParam(helloClassForm);
        System.out.println(helloClassForm.toString());
    }

    /**
     * 注解注释在字段上
     *
     * @param object 类
     * @throws IllegalAccessException 从字段取值
     */
    private void checkFieldParam(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            ParamConversion annotation = field.getAnnotation(ParamConversion.class);
            if (annotation == null || String.class != field.getType()) {
                return;
            }
            ParamConversion.Convert convert = annotation.convert();
            // 类中的成员变量为private,故必须进行此操作
            field.setAccessible(true);
            String fieldValue = (String) field.get(object);
            if (ParamConversion.Convert.B2N.equals(convert)) {
                if (StringUtils.isBlank(fieldValue)) {
                    field.set(object, null);
                }
            } else if (ParamConversion.Convert.N2B.equals(convert)) {
                if (fieldValue == null) {
                    field.set(object, "");
                }
            }
        }
    }

    /**
     * 注解注释在类上
     *
     * @param object 类
     * @throws IllegalAccessException 从字段取值
     */
    private void checkClassParam(Object object) throws IllegalAccessException {
        ParamConversion annotation = object.getClass().getAnnotation(ParamConversion.class);
        if (annotation == null) {
            return;
        }
        ParamConversion.Convert convert = annotation.convert();

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (String.class != field.getType()) {
                return;
            }
            // 类中的成员变量为private,故必须进行此操作
            field.setAccessible(true);
            String fieldValue = (String) field.get(object);
            if (ParamConversion.Convert.B2N.equals(convert)) {
                if (StringUtils.isBlank(fieldValue)) {
                    field.set(object, null);
                }
            } else if (ParamConversion.Convert.N2B.equals(convert)) {
                if (fieldValue == null) {
                    field.set(object, "");
                }
            }
        }
    }

}

