package cn.amos.frame.dubbo;

import cn.amos.frame.dubbo.model.GenderEnum;
import cn.amos.frame.dubbo.model.UserForm;
import cn.amos.frame.dubbo.model.UserInfoVO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DESCRIPTION: Main
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/10/27
 */
public class Main {

    /**
     * Map<接口, 实现类>
     * Map<Class<?>, ServiceImpl#instance>
     */
    private static final Map<Class<?>, Object> SINGLETON_MAP = new ConcurrentHashMap<>(16);

    private static void loadServiceImpl(Class<?> clazz) {
        // 基于 Java API 根据接口加载实现类
        ServiceLoader<?> load = ServiceLoader.load(clazz);

        load.forEach(service -> {
            /// beanName首字母小写
            // String beanName = service.getClass().getSimpleName();
            // if (Character.isUpperCase(beanName.charAt(0))) {
            //     beanName = Character.toLowerCase(beanName.charAt(0)) + beanName.substring(1);
            // }

            if (SINGLETON_MAP.get(clazz) == null) {
                synchronized (SINGLETON_MAP) {
                    if (SINGLETON_MAP.get(clazz) == null) {
                        try {
                            SINGLETON_MAP.put(clazz, service.getClass().newInstance());
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /**
     * 模拟方法调用: 接口 --> 方法 <返回值> 方法名(<参数类型: 参数>...)
     */
    public static void main(String[] args0) {
        // 模拟初始化接口与实现类，基于JDK SPI
        Class<?> clazz = HelloService.class;
        loadServiceImpl(clazz);

        // sayHello
        sayHello(clazz.getName());

        // register
        register(clazz.getName());
    }

    private static void register(String className) {
        // 方法名
        String methodName = "register";
        // 参数类型
        Class<?>[] parameterTypes = new Class[]{UserForm.class};
        // 返回值类型
        Class<?> responseType = UserInfoVO.class;
        // 参数
        Object[] params = new Object[]{new UserForm()
                .setAccount("18937128861")
                .setUsername("amos.wang")
                .setGender(GenderEnum.MAN)
                .setTotalConsume(new BigDecimal("1000000")
        )};

        CallRequest callRequest = new CallRequest()
                .setClassName(className)
                .setMethodName(methodName)
                .setParameterTypes(parameterTypes)
                .setParams(params)
                .setResponseType(responseType);

        Object response = callMethod(callRequest);
        System.out.println(response);
    }

    private static void sayHello(String className) {
        // 方法名
        String methodName = "sayHello";
        // 参数类型
        Class<?>[] parameterTypes = new Class[]{String.class, String.class};
        // 返回值类型
        Class<?> responseType = String.class;
        // 参数
        Object[] params = new Object[]{"amos.wang", "nice to meet you!"};

        CallRequest callRequest = new CallRequest()
                .setClassName(className)
                .setMethodName(methodName)
                .setParameterTypes(parameterTypes)
                .setParams(params)
                .setResponseType(responseType);

        Object response = callMethod(callRequest);
        System.out.println(response);
    }

    private static Object callMethod(CallRequest callRequest) {
        try {
            Class<?> clazz = Class.forName(callRequest.getClassName());

            Object instance = SINGLETON_MAP.get(clazz);

            Method method = clazz.getMethod(callRequest.getMethodName(), callRequest.getParameterTypes());
            Object response = method.invoke(instance, callRequest.getParams());

            return callRequest.getResponseType().cast(response);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
