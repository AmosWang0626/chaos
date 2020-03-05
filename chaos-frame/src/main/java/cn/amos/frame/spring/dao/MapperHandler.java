package cn.amos.frame.spring.dao;

import cn.amos.frame.spring.api.MySelect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * DESCRIPTION: MapperHandler
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public class MapperHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(MySelect.class)) {
            MySelect annotation = method.getAnnotation(MySelect.class);
            System.out.println(annotation.value()[0]);

            return Arrays.asList("amos", "grace");
        }

        return "amos.wang";
    }
}
