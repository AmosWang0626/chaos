package cn.amos.frame.dubbo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
     * Map<BeanName, ServiceImpl#instance>
     */
    private static final Map<String, Object> SINGLETON_MAP = new ConcurrentHashMap<>(16);
    /**
     * Map<Service.class, BeanName>
     */
    private static final Map<Class<?>, String> ALL_INTERFACE = new ConcurrentHashMap<>(16);

    private static void loadService(Class<?> clazz) {
        // java spi load interface implements class
        ServiceLoader<?> load = ServiceLoader.load(clazz);

        load.forEach(service -> {
            // beanName首字母小写
            String beanName = service.getClass().getSimpleName();
            if (Character.isUpperCase(beanName.charAt(0))) {
                beanName = Character.toLowerCase(beanName.charAt(0)) + beanName.substring(1);
            }

            if (SINGLETON_MAP.get(beanName) == null) {
                synchronized (SINGLETON_MAP) {
                    if (SINGLETON_MAP.get(beanName) == null) {
                        try {
                            ALL_INTERFACE.put(clazz, beanName);
                            SINGLETON_MAP.put(beanName, service.getClass().newInstance());
                        } catch (InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args0) {
        // 模拟方法调用: 接口 --> <返回值> 方法(<参数类型: 参数>)

        // 接口
        Class<HelloService> clazz = HelloService.class;
        // 方法名
        String methodName = "sayHello";
        // 参数类型
        Class<?>[] parameterTypes = new Class[]{String.class, String.class};
        // 返回值类型
        Class<?> responseType = String.class;
        // 参数
        Object[] params = new Object[]{"amos.wang", "nice to meet you!"};

        loadService(clazz);

        try {
            String key = ALL_INTERFACE.get(clazz);
            Object instance = SINGLETON_MAP.get(key);

            Method method = clazz.getMethod(methodName, parameterTypes);
            Object response = method.invoke(instance, params);

            System.out.println(responseType.cast(response));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
