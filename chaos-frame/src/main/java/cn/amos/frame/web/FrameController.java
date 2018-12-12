package cn.amos.frame.web;

import cn.amos.frame.disconf.DisConfConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/12/12
 */
@RestController
@RequestMapping("frame")
public class FrameController {

    @Value("${a.b.c}")
    private String hello;

    @Resource
    private DisConfConfig disConfConfig;


    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return hello;
    }


    @GetMapping(value = "disconf")
    public String getDisconf() {
        return "HOST: " + disConfConfig.getRedisHost() + ", PORT: " + disConfConfig.getRedisPort();
    }
}
