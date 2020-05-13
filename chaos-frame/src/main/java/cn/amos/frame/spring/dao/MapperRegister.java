package cn.amos.frame.spring.dao;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * DESCRIPTION: PrivateRegister
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
@Component
public class MapperRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder;
        /// 这句不行，为什么呢？MapperService没有实例化 
        // builder = BeanDefinitionBuilder.genericBeanDefinition(MapperService.class);
        builder = BeanDefinitionBuilder.genericBeanDefinition(MapperFactoryBean.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        ConstructorArgumentValues argumentValues = beanDefinition.getConstructorArgumentValues();
        argumentValues.addGenericArgumentValue("cn.amos.frame.spring.dao.UserMapper");
        registry.registerBeanDefinition(beanDefinition.getClass().getSimpleName(), beanDefinition);
    }

}
