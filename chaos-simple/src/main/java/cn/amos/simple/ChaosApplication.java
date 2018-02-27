package cn.amos.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author DaoyuanWang
 */
@Configuration
@ComponentScan("cn.amos")
@EnableAutoConfiguration
@EnableScheduling
public class ChaosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaosApplication.class, args);
    }
}
