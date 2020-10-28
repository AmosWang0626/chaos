package cn.amos.frame.dubbo;

import cn.amos.frame.dubbo.model.UserForm;
import cn.amos.frame.dubbo.model.UserInfoVO;

/**
 * PROJECT: permit
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/28
 */
public interface HelloService {

    /**
     * 给指定人发消息
     *
     * @param name    名字
     * @param message 消息
     * @return 完整消息
     */
    String sayHello(String name, String message);

    /**
     * 用户注册
     *
     * @param userForm 用户表单
     * @return 用户信息VO
     */
    UserInfoVO register(UserForm userForm);

}
