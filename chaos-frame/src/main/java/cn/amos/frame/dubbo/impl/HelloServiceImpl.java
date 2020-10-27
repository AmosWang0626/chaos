package cn.amos.frame.dubbo.impl;

import cn.amos.frame.dubbo.HelloService;

/**
 * PROJECT: permit
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/28
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name, String info) {
        return "Hello " + name + ", " + info;
    }

}

