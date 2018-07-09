package cn.amos.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
@RestController("hello")
public class HelloController {

    @Value("${a.b.c}")
    private String hello;

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return hello;
    }
}
