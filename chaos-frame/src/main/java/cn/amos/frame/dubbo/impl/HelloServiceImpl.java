package cn.amos.frame.dubbo.impl;

import cn.amos.frame.dubbo.HelloService;
import cn.amos.frame.dubbo.model.UserForm;
import cn.amos.frame.dubbo.model.UserInfoVO;

/**
 * PROJECT: permit
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/28
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name, String message) {
        return "Hello " + name + ", " + message;
    }

    @Override
    public UserInfoVO register(UserForm userForm) {
        UserInfoVO userInfoVO = new UserInfoVO();
        if (userForm != null) {
            userInfoVO.setAccount(userForm.getAccount());
            userInfoVO.setUsername(userForm.getUsername());
            userInfoVO.setAddress(userForm.getAddress());
            userInfoVO.setAge(userForm.getAge());
            userInfoVO.setGender(userForm.getGender());
            userInfoVO.setTotalConsume(userForm.getTotalConsume());
        }

        return userInfoVO;
    }
}

