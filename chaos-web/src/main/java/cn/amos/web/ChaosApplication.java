package cn.amos.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author DaoyuanWang
 */
@SpringBootApplication(scanBasePackages = "cn.amos")
@EnableScheduling
@EnableAspectJAutoProxy
public class ChaosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaosApplication.class, args);
    }
}
