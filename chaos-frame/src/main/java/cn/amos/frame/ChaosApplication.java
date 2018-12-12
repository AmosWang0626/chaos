package cn.amos.frame;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author DaoyuanWang
 */
@SpringBootApplication(scanBasePackages = "cn.amos.frame")
@EnableScheduling
@EnableAspectJAutoProxy
@EnableDubboConfiguration
@ImportResource({"classpath:spring-context.xml"})
@PropertySource({"classpath:disconf.properties"})
public class ChaosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaosApplication.class, args);
    }
}
