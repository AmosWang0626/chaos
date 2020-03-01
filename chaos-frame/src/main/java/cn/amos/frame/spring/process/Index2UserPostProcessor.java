package cn.amos.frame.spring.process;

import cn.amos.frame.spring.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * DESCRIPTION: 将已经在 Spring 里的 indexService 换成 UserService
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
//@Component
public class Index2UserPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        GenericBeanDefinition indexService = (GenericBeanDefinition) factory.getBeanDefinition("indexService");
        indexService.setBeanClass(UserService.class);
    }
}
