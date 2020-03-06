package cn.amos.frame.mybatis;

import cn.amos.frame.mybatis.config.MyBatisConfig;
import cn.amos.frame.mybatis.dao.UserMapper;
import cn.amos.frame.mybatis.plugin.PageModule;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * DESCRIPTION: MyBatisTest
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
public class MyBatisTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyBatisConfig.class);

        UserMapper userMapper = context.getBean(UserMapper.class);

        PageModule pageModule = new PageModule();
        pageModule.setPage(1).setSize(2);
        userMapper.queryByPage(pageModule).forEach(user ->
                System.out.printf("账号: %s, 用户名: %s\n", user.getAccount(), user.getUsername()));
        Integer count = pageModule.getCount();
        System.out.println("总记录数: " + count);
    }

}
