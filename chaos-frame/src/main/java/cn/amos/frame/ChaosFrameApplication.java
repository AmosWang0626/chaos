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
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableDubboConfiguration
@ImportResource({"classpath:spring-context.xml"})
@PropertySource({"classpath:disconf.properties"})
public class ChaosFrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChaosFrameApplication.class, args);
    }
}
