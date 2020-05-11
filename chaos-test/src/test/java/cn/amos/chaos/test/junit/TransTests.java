package cn.amos.chaos.test.junit;

import cn.amos.chaos.test.service.ManageService;
import cn.amos.chaos.test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * DESCRIPTION: 事务测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/4/15
 */
@SpringBootTest
public class TransTests {

    @Resource
    private UserService userService;
    @Resource
    private ManageService manageService;

    /**
     * 同一个类，保存成功（没有触发事务回滚）
     * save方法加了事务；在同一个类里边，save2调用save方法，save方法加了事务。
     * Spring事务管理用的是AOP，AOP底层为动态代理，方法上加了事务，就会产生一个代理对象。
     * 既然是代理，原始方法肯定是固定的，代理也是把事务包裹在原始方法周围；
     * save2调用save，等于是方法调用，也就是调用原始save方法，所以事务无效。
     */
    @Test
    public void sameClass() {
        userService.save2(UUID.randomUUID().toString());
    }

    /**
     * 不同的类，保存失败（触发了事务）
     * 还拿上边的理论，调用save方法，save方法已经被事务包裹了。
     */
    @Test
    public void unSameClass() {
        manageService.save();
    }

}
