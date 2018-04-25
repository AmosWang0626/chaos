package cn.amos.simple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DaoyuanWang
 */
@Configuration
@ComponentScan("cn.amos")
@EnableAutoConfiguration
@EnableScheduling
@RestController
public class ChaosApplication {

    @Value("${a.b.c}")
    private String hello;

    @RequestMapping("/hello")
    public String hello(){
        return hello;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChaosApplication.class, args);
    }
}
