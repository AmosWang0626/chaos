package cn.amos.frame.spring;

import cn.amos.frame.spring.service.IndexService;
import cn.amos.frame.spring.service.UserService;
import cn.amos.frame.spring.utils.AmosUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * DESCRIPTION: Test Spring Application
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/1/2020
 */
@ComponentScan("cn.amos.frame.spring")
public class TestSpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestSpringApplication.class);

        /// 关闭 Spring 循环引用
        // AbstractAutowireCapableBeanFactory beanFactory =
        //         (AbstractAutowireCapableBeanFactory) context.getBeanFactory();
        // beanFactory.setAllowCircularReferences(false);

        context.refresh();

        AmosUtils.println("BeanDefinitionNames ↓↓↓↓↓↓↓↓↓↓");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            AmosUtils.println(beanDefinitionName, 2);
        }
        System.out.println();

        IndexService indexService = context.getBean(IndexService.class);
        AmosUtils.println(indexService.getUserService());

        UserService userService = context.getBean(UserService.class);
        AmosUtils.println(userService.getIndexService());
    }

}
