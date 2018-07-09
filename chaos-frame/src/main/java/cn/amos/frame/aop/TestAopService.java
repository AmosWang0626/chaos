package cn.amos.frame.aop;

import org.springframework.stereotype.Service;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/7/9
 */
@Service
public class TestAopService {

    public String hello(String name) {
        return "Hello " + name + ", this is test aop service";
    }
}
