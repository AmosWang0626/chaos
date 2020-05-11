package cn.amos.chaos.test.service.impl;

import cn.amos.chaos.test.service.ManageService;
import cn.amos.chaos.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * DESCRIPTION: UserServiceImpl
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2020/4/15
 */
@Service("manageService")
public class ManageServiceImpl implements ManageService {

    @Resource
    private UserService userService;

    @Override
    public void save() {
        userService.save("Manage!!!");
    }
}
