package cn.amos.frame.dubbo.impl;

import cn.amos.frame.dubbo.DubboService;
import org.springframework.stereotype.Service;

/**
 * PROJECT: permit
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/11/28
 */
@com.alibaba.dubbo.config.annotation.Service
@Service("dubboService")
public class DubboServiceImpl implements DubboService {

    @Override
    public String sayHello(String name) {
        System.out.println("==================================");
        System.out.println("Hello " + name);
        System.out.println("==================================");
        return "Hello " + name;
    }
}

