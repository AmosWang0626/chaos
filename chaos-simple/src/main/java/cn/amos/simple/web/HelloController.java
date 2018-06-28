package cn.amos.simple.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PROJECT: chaos
 * DESCRIPTION: 类说明
 *
 * @author DaoYuanWang
 * @date 2018/6/28
 */
@RestController
public class HelloController {

    @Value("${a.b.c}")
    private String hello;

    @RequestMapping("/hello")
    public String hello() {
        return hello;
    }
}
