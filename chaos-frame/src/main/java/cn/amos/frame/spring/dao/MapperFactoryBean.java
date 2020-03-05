package cn.amos.frame.spring.dao;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * DESCRIPTION: PrivateFactoryBean
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public class MapperFactoryBean implements FactoryBean<Object> {

    private Class<?> clazz;

    public MapperFactoryBean(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(), new Class[]{clazz}, new MapperHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}
