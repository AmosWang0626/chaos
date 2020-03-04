package cn.amos.frame.tomcat.servlet;

import cn.amos.frame.tomcat.config.ServletConfig;
import cn.amos.frame.tomcat.config.ServletMapping;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * DESCRIPTION: MyServlet
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
public class MyServlet extends BaseServlet {

    @Override
    public void doGet(MyHttpRequest request, MyHttpResponse response) throws Exception {
        ServletConfig servletConfig = ServletMapping.get(request.getUrl());
        if (servletConfig == null) {
            response.format(HttpStatus.NOT_FOUND, null);
            return;
        }

        Class<?> clazz = Class.forName(servletConfig.getClazz());
        Object instance = clazz.newInstance();
        Proxy.newProxyInstance(
                clazz.getClassLoader(), instance.getClass().getInterfaces(),
                (proxy, method, args) -> method.invoke(instance, args)
        );

        Method method = null;
        // 根据方法名获取无参方法
        try {
            method = clazz.getMethod(servletConfig.getName());
        } catch (Exception e) {
            /// e.printStackTrace();
        }
        // 如果是有参方法，此处投机，根据方法名和参数数量获取 method；
        // 问题就是两个方法，参数类型不一样、但参数数量一样时，默认只会默认取第一个命中的方法
        if (method == null) {
            Method[] methods = clazz.getMethods();
            for (Method temp : methods) {
                if (temp.getName().equals(servletConfig.getName())
                        && temp.getParameterCount() == request.getParams().size()) {
                    method = temp;
                    break;
                }
            }
        }

        if (method == null) {
            System.out.println("ERROR: 方法不存在");
            response.format(HttpStatus.NOT_FOUND, null);
            return;
        }

        int paramCount = method.getParameterCount();
        Parameter[] parameters = method.getParameters();
        Object result;
        if (paramCount != 0) {
            List<String> params = request.getParams();
            Object[] paramArr = new Object[paramCount];
            for (int i = 0; i < paramCount; i++) {
                paramArr[i] = parameters[i].getType().cast(params.get(i));
            }
            result = method.invoke(instance, paramArr);
        } else {
            result = method.invoke(instance);
        }

        response.format(HttpStatus.OK, result.toString());
    }

    @Override
    public void doPost(MyHttpRequest request, MyHttpResponse response) {

    }

}
